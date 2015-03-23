package Devoir_3;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.NoSuchElementException;

/**
 * Luka Virtual Machine (LVM) -- An interpreter for the Luka programming
 * language.
 *
 * @author Marcel Turcotte
 */
public class Interpreter {

	/**
	 * Class variable. Newline symbol on this machine at run-time.
	 */
	private static final String NL = System.getProperty("line.separator");

	/**
	 * Instance variable. The operands stack.
	 */
	private Stack<Token> operands;

	/**
	 * Instance variable. A reference to a lexical analyzer (Reader).
	 */
	private Reader r;

	/**
	 * Instance variable. Coordinate x of the graphics state.
	 */
	private int gsX;

	/**
	 * Instance variable. Coordinate y of the graphics state.
	 */
	private int gsY;

	/**
	 * Instance variable. Color of the pen.
	 */
	private Color gsColor;

	private String text, charac;

	/**
	 * Initializes this newly created interpreter so that the operand stack is
	 * empty, the accumulator is set 0, the cursor is at (0,0), and the default
	 * color is blue.
	 */
	public Interpreter() {
		reset();
	}

	/**
	 * Crée nouveau dictionnaire
	 */
	Dictionary dictionary = new Dictionary();

	/**
	 * Auxiliary method that resets the graphics state of this interpreter.
	 */
	private void reset() {

		operands = new LinkedStack<>();

		gsX = 0;
		gsY = 0;
		gsColor = Color.BLUE;
	}

	/**
	 * Executes the input program and displays the result onto the Graphics
	 * object received as an argument.
	 *
	 * @param program
	 *            contains the source to be executed.
	 * @param g
	 *            the graphics context.
	 */

	public void execute(String program, Graphics g) throws LukasSyntaxException {

		reset();

		r = new Reader(program);

		g.setColor(gsColor);

		while (r.hasMoreTokens()) {

			try {

				Token t = r.nextToken();

				if (!t.isNumber()) {

					text = t.getSymbol();

					charac = Character.toString(text.charAt(0));
				}

				if (t.isNumber()) {

					operands.push(t);

					/**
					 * vérifie si le premier caractère du token est "/". Si oui,
					 * la méthode execute_quotedSymbol est appelée.
					 */
				} else if (charac.equals("/")) {

					String Variable = "";

					for (int i = 1; i < text.length(); i++) {
						Variable = Variable
								+ new StringBuilder().append(text.charAt(i))
										.toString();
					}
					execute_quotedSymbol(Variable);

					/**
					 * vérifie si le dictionnaire contient le symbole spécifié.
					 * si oui, execute_symboleEvaluation est appelée
					 */

				} else if (dictionary.contains(text)) {

					operands.push(t);

					execute_symbolEvaluation();

				} else if (t.getSymbol().equals("undef")) {

					execute_undef();

				} else if (t.getSymbol().equals("def")) {

					execute_def();

				} else if (t.getSymbol().equals("set")) {

					execute_set();

				} else if (t.getSymbol().equals("add")) {

					execute_add();

				} else if (t.getSymbol().equals("sub")) {

					execute_sub();

				} else if (t.getSymbol().equals("mul")) {

					execute_mul();

				} else if (t.getSymbol().equals("div")) {

					execute_div();

				} else if (t.getSymbol().equals("pop")) {

					execute_pop();

				} else if (t.getSymbol().equals("clear")) {

					execute_clear();

				} else if (t.getSymbol().equals("pstack")) {

					execute_pstack();

				} else if (t.getSymbol().equals("moveto")) {

					execute_moveto();

				} else if (t.getSymbol().equals("lineto")) {

					execute_lineto(g);

				} else if (t.getSymbol().equals("arc")) {

					execute_arc(g);

				} else if (t.getSymbol().equals("quit")) {

					execute_quit();

				} else {

					System.out.println("ILLEGAL SYMBOL: " + t);

				}

				/**
				 * attrape l'exception et lance l'exception LukasSyntaxException.
				 */

			} catch (NoSuchElementException e1) {

				String message;
				String pairs = "{elems = [";

				for (int i = 0; i < dictionary.getLengthOfDictionary(); i++) {
					pairs = pairs + "{key =" + dictionary.getkey(i)
							+ ", value = " + dictionary.getValue(i).getNumber()
							+ "}";
					if (i < dictionary.getLengthOfDictionary() - 1) {
						pairs = pairs + ",";
					}
				}
				pairs = pairs + "]}";

				message = e1.getMessage() + "\n" + pairs + "\n" + operands.toString() + "\n" + "LukasSyntaxException : " + dictionary.getErrorKey() + " not found : caught LukasSyntaxException";

				throw new LukasSyntaxException(message);
				
			} catch (NullPointerException e2) {

				String message;
				String pairs = "{elems = [";

				for (int i = 0; i < dictionary.getLengthOfDictionary(); i++) {
					pairs = pairs + "{key =" + dictionary.getkey(i)
							+ ", value = " + dictionary.getValue(i).getNumber()
							+ "}";
					if (i < dictionary.getLengthOfDictionary() - 1) {
						pairs = pairs + ",";
					}
				}

				pairs = pairs + "]}";

				message = e2.getMessage() + "\n" + pairs + "\n" + operands.toString() + "\n" + "LukasSyntaxException : " + dictionary.getErrorKey() + " not found : caught LukasSyntaxException";

				throw new LukasSyntaxException(message);

			}

		}

	}

	// -----------------------------------------------------

	/**
	 * prend le symbole sans "/" et le pousse sur la pile
	 * 
	 * @param m
	 *            : la clé qui sera la référence dans le dictionnaire. Elle
	 *            n'est cepandant pas mise dans le dictionnaire dans cette
	 *            méthode
	 */
	private void execute_quotedSymbol(String m) {
		Token symbol = new Token(m);
		operands.push(symbol);
	}

	/**
	 * retire les deux éléments sur le dessus de la pile et les insère dans le
	 * dictionnaire
	 */
	private void execute_def() {
		Token Value = operands.pop();
		Token Symbol = operands.pop();

		dictionary.put(Symbol.getSymbol(), Value);
	}

	/**
	 * évalue la valeur du symbole sur le dessus de la pile
	 * 
	 * @throws LukasSyntaxException
	 */
	private void execute_symbolEvaluation() throws LukasSyntaxException {
		Token Symbol = operands.pop();

		if (!Symbol.isSymbol()) {
			throw new LukasSyntaxException("LukasSyntaxException : "
					+ Symbol.getSymbol()
					+ " not found : caught LukasSyntaxException");
		}

		operands.push(dictionary.get(Symbol.getSymbol()));
	}

	/**
	 * retire les deux éléments sur le dessus de la pile et remplace la valeur
	 * de cet élément dans le dictionnaire par la valeur donnée
	 * 
	 * @throws LukasSyntaxException
	 */
	private void execute_set() throws LukasSyntaxException {
		Token newValue = operands.pop();
		Token Symbol = operands.pop();

		if (dictionary.get(Symbol.getSymbol()) == null) {
			throw new LukasSyntaxException("LukasSyntaxException : "
					+ Symbol.getSymbol()
					+ " not found : caught LukasSyntaxException");
		}
		dictionary.replace(Symbol.getSymbol(), newValue);

	}

	/**
	 * retire un l'élément spécifié du dictionnaire
	 */
	private void execute_undef() {

		Token VariableToUndef = operands.pop();

		dictionary.remove(VariableToUndef.getSymbol());
	}

	// -----------------------------------------------------
	private void execute_add() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op1.getNumber() + op2.getNumber());
		operands.push(res);
	}

	private void execute_sub() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op2.getNumber() - op1.getNumber());
		operands.push(res);
	}

	private void execute_mul() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op1.getNumber() * op2.getNumber());
		operands.push(res);
	}

	private void execute_div() {
		Token op1 = operands.pop();
		Token op2 = operands.pop();
		Token res = new Token(op2.getNumber() / op1.getNumber());
		operands.push(res);
	}

	private void execute_pop() {
		operands.pop();
	}

	private void execute_moveto() {
		Token y = operands.pop();
		Token x = operands.pop();
		gsX = x.getNumber();
		gsY = y.getNumber();
	}

	private void execute_lineto(Graphics g) {
		Token y = operands.pop();
		Token x = operands.pop();
		g.drawLine(gsX, gsY, x.getNumber(), y.getNumber());
		gsX = x.getNumber();
		gsY = y.getNumber();
	}

	private void execute_arc(Graphics g) {
		Token a2 = operands.pop();
		Token a1 = operands.pop();
		Token r = operands.pop();
		g.drawArc(gsX, gsY, r.getNumber(), r.getNumber(), a1.getNumber(),
				a2.getNumber());
	}

	private void execute_pstack() {

		System.out.println(operands);

	}

	private void execute_clear() {
		while (!operands.isEmpty()) {
			operands.pop();
		}
	}

	private void execute_quit() {
		System.out.println("Bye!");
		System.exit(0);
	}

}
