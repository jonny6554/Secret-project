package Devoir_3;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

/**
 * Viewer implements the graphical aspect of this application.
 * <ul>
 * <li>The viewer has a <code>Display</code> to render the result of the
 * execution of a <b>Luka</b> program;</li>
 * <li>It has a <code>TextArea</code> that allows the user to input a (valid)
 * program;</li>
 * <li>Has an interpreter that will be rendering the result of the execution of
 * a program onto the <code>Display</code>;</li>
 * <li>Has a button labeled ``execute''. The <code>Viewer</code> registers
 * itself as the event-handler of the button.</li>
 * </ul>
 *
 * @author Marcel Turcotte
 */
public class Viewer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * A reference to the interpreter.
	 */
	private final Interpreter lvm; // Luka Virtual Machine

	/**
	 * A reference to the display, where the result of the execution of the Luka
	 * programs will be displayed.
	 */
	private final Display display;

	/**
	 * The execute button.
	 */
	private final JButton bExecute = new JButton("Run");

	/**
	 * A <code>TextArea</code> for entering the (Luka) code.
	 */
	private final JTextArea input = new JTextArea(6, 80);

	/**
	 * Creates the visual display of the application. Creates a Display, Button
	 * and TextArea.
	 *
	 * @param lvm
	 *            a reference to an interpreter.
	 */
	public Viewer() {

		super("DrLuka");

		this.lvm = new Interpreter();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);

		// Display will be calling our method paint
		display = new Display(this);

		display.setSize(400, 400);
		display.setBackground(Color.WHITE);

		add(display, BorderLayout.CENTER);

		// When the is pressed, we will execute the program typed in the text
		// area
		bExecute.addActionListener(this);

		Panel controls = new Panel();
		controls.setLayout(new FlowLayout());
		controls.add(bExecute);

		Panel console = new Panel();
		console.setLayout(new BorderLayout());

		input.setBackground(Color.LIGHT_GRAY);

		JScrollPane sp = new JScrollPane(input);

		console.add(sp, BorderLayout.CENTER);
		console.add(controls, BorderLayout.SOUTH);

		add(console, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	/**
	 * Calls to display.repaint(), which in turns calls the method paint of the
	 * component with a reference to the Graphics object. Finally, the method
	 * paint calls our own method
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bExecute) {
			display.repaint();
		}

	}

	/**
	 * Obtains the Luka program from the text area. Calls the method
	 * <code>execute</code> of the interpreter, passing the program and
	 * graphical context.
	 *
	 * @param g
	 *            the graphical context
	 */
	public void execute(Graphics g) {

		try{
		String program = input.getText();

		lvm.execute(program, g);
		}catch(LukasSyntaxException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

}
