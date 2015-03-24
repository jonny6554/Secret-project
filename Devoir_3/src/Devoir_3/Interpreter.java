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
	//CETTE CONSTANTE N'AS PAS �T� UTILIS�. "\n" a plut�t �t� utilis�.
	//private static final String NL = System.getProperty("line.separator");

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
	
	/**
	 * Cr�e un nouveau dictionnaire
	 */
	Dictionary dictionary;

	/**
	 * Initializes this newly created interpreter so that the operand stack is
	 * empty, the accumulator is set 0, the cursor is at (0,0), and the default
	 * color is blue.
	 */
	public Interpreter() {
		reset();
	}

	/**
	 * Auxiliary method that resets the graphics state of this interpreter.
	 */
	private void reset() {

		operands = new LinkedStack<>();
		dictionary = new Dictionary();
		
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
		//On r�initialise les param�tres � leurs d�fauts.
		reset();
		//D�claration des variables et dictionnaire des donn�es.
		String text = ""; 	//La valeur du token lorsqu'elle est un symbol
		char charac = ' ';	//Le premier caract�re de la variable text.
		
		r = new Reader(program);

		g.setColor(gsColor);

		while (r.hasMoreTokens()) {

			Token t = r.nextToken();
			
			try {

				if (t.isSymbol()) {

					text = t.getSymbol();

					charac = text.charAt(0);
				}

				if (t.isNumber()) {
					
					operands.push(t);

				 //V�rifie si le premier caract�re du token est "/". Si oui,
				 //la m�thode execute_quotedSymbol est appel�e.
					
				} else if (charac == '/') {

					String variable = "";
					//On enl�ve le "/" devant le String
					for (int i = 1; i < text.length(); i++) {
						variable = variable
								+ new StringBuilder().append(text.charAt(i))
										.toString();
					}
					
					execute_quotedSymbol(variable);

				 //V�rifie si le dictionnaire contient le symbole sp�cifi�.
				 //si oui, execute_symboleEvaluation est appel�e
					
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

			} catch (NoSuchElementException e1) {

				throwLukasSyntaxException(e1, t);
				
			} catch (NullPointerException e2) {

				throwLukasSyntaxException(e2, t);

			} catch (EmptyStackException e3) {
				
				throwLukasSyntaxException(e3, t);
				
			}

		}

	}
	
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
	

	// -------------------------------------------------------------------------------------------
	// --------------------------Nouvelle code d�bute ici.----------------------------------------
	// -------------------------------------------------------------------------------------------

	/**
	 * Prend le symbole sans "/" et le pousse sur la pile.
	 * 
	 * @param m
	 *            : La cl� qui sera la r�f�rence dans le dictionnaire. Elle
	 *            n'est cependant pas mise dans le dictionnaire dans cette
	 *            m�thode
	 */
	private void execute_quotedSymbol(String m) {
		Token symbol = new Token(m);
		
		operands.push(symbol);
	}

	/**
	 * Retire les deux �l�ments sur le dessus de la pile et les ins�re dans le
	 * dictionnaire.
	 */
	private void execute_def() {
		Token value = operands.pop();
		Token symbol = operands.pop();

		dictionary.put(symbol.getSymbol(), value);
	}

	/**
	 * �value la valeur du symbole sur le dessus de la pile.
	 * 
	 */
	private void execute_symbolEvaluation(){
		Token symbol = operands.pop();
		
		operands.push(dictionary.get(symbol.getSymbol()));
	}

	/**
	 * Retire les deux �l�ments sur le dessus de la pile et remplace la valeur
	 * de cet �l�ment dans le dictionnaire par la valeur donn�e.
	 * 
	 */
	private void execute_set() {
		Token newValue = operands.pop();
		Token symbol = operands.pop();
		
		dictionary.replace(symbol.getSymbol(), newValue);

	}

	/**
	 * Retire un l'�l�ment sp�cifi� du dictionnaire.
	 */
	private void execute_undef() {

		Token variableToUndef = operands.pop();

		dictionary.remove(variableToUndef.getSymbol());
	}
	
	/**
	 * Cette m�thode lance un LukasSyntaxException. Elle est appel� lorsque une erreur
	 * d'un autre type est lanc�.
	 * 
	 * @param e : indique l'erreur qui a �t� lanc�.
	 * @param t : indique le Token probl�matique en question.
	 */
	private void throwLukasSyntaxException(Exception e, Token t){
		//D�claration des variables et dictionnaire des donn�es.
		String message;
		//Module
		//Le message contenu dans le LukasSyntaxException.
		message = e.getMessage() + operands.toString() + "\n" + "LukasSyntaxException : " + t.getSymbol() + " was erroneous : caught LukasSyntaxException";
		//Retour de la variable r�sultat
		throw new LukasSyntaxException(message);
	}
	
}
