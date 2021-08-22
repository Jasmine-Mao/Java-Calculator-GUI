import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class SimpleCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField calculatorDisplay;

	/**
	 * Launch the application.
	 */
	String displayOutput = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator frame = new SimpleCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalculator() {
		setResizable(false);
		// Frame of the calculator
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Output displayed to the user. User can interact with this field, and all
		// numbers will be displayed here
		calculatorDisplay = new JTextField();
		calculatorDisplay.setForeground(Color.BLACK);
		calculatorDisplay.setBackground(Color.WHITE);
		calculatorDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					displayOutput = calculatorDisplay.getText();
					String infixExpression = displayOutput;
					infixEvaluation i = new infixEvaluation();
					calculatorDisplay.setText(displayOutput = Integer.toString(i.evaluate(infixExpression)));
				} catch (Exception UnsupportedOperationException) {
					calculatorDisplay.setText("ERROR");
				}
			}
		});
		calculatorDisplay.setFont(new Font("Open Sans", Font.BOLD, 24));
		calculatorDisplay.setBounds(10, 10, 370, 62);
		contentPane.add(calculatorDisplay);
		calculatorDisplay.setColumns(10);

		// Open bracket "(" button
		JButton openBracket = new JButton("(");
		openBracket.setBackground(Color.DARK_GRAY);
		openBracket.setForeground(Color.WHITE);
		openBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "(");
			}
		});
		openBracket.setFont(new Font("Open Sans", Font.PLAIN, 18));
		openBracket.setBounds(10, 82, 85, 46);
		contentPane.add(openBracket);

		// Close Bracket ")" button
		JButton closeBracket = new JButton(")");
		closeBracket.setBackground(Color.DARK_GRAY);
		closeBracket.setForeground(Color.WHITE);
		closeBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + ")");
			}
		});
		closeBracket.setFont(new Font("Open Sans", Font.PLAIN, 18));
		closeBracket.setBounds(105, 82, 85, 46);
		contentPane.add(closeBracket);

		// Backspace "DEL" button to delete numbers/symbols in the calculatorDisplay
		JButton backspace = new JButton("DEL");
		backspace.setBackground(Color.DARK_GRAY);
		backspace.setForeground(Color.WHITE);
		backspace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput.substring(0, displayOutput.length() - 1));
			}
		});
		backspace.setFont(new Font("Open Sans", Font.PLAIN, 18));
		backspace.setBounds(200, 82, 85, 46);
		contentPane.add(backspace);

		// Clear button "clear" to fully clear everything from the calculatorDisplay
		JButton clear = new JButton("CE");
		clear.setBackground(Color.RED);
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = "");
			}
		});
		clear.setFont(new Font("Open Sans", Font.PLAIN, 18));
		clear.setBounds(295, 82, 85, 46);
		contentPane.add(clear);

		// Addition "+" button
		JButton Add = new JButton("+");
		Add.setBackground(Color.DARK_GRAY);
		Add.setForeground(Color.WHITE);
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "+");
			}
		});
		Add.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Add.setBounds(295, 250, 85, 46);
		contentPane.add(Add);

		// Subtraction "-" button
		JButton Subtract = new JButton("-");
		Subtract.setBackground(Color.DARK_GRAY);
		Subtract.setForeground(Color.WHITE);
		Subtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "-");
			}
		});
		Subtract.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Subtract.setBounds(295, 306, 85, 46);
		contentPane.add(Subtract);

		// Multiplication "*" button
		JButton Multiply = new JButton("*");
		Multiply.setBackground(Color.DARK_GRAY);
		Multiply.setForeground(Color.WHITE);
		Multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "*");
			}
		});
		Multiply.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Multiply.setBounds(295, 138, 85, 46);
		contentPane.add(Multiply);

		// Division "/" button
		JButton Divide = new JButton("/");
		Divide.setBackground(Color.DARK_GRAY);
		Divide.setForeground(Color.WHITE);
		Divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "/");
			}
		});
		Divide.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Divide.setBounds(295, 194, 85, 46);
		contentPane.add(Divide);

		// Equal sign "=" button
		JButton Equals = new JButton("=");
		Equals.setBackground(Color.GREEN);
		Equals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					displayOutput = calculatorDisplay.getText();
					// In case everything was just typed into the JTextField, set the display output
					// to what's in the calculator's display
					// Still works if everything is typed in manually with the buttons
					String infixExpression = displayOutput;
					infixEvaluation i = new infixEvaluation();
					calculatorDisplay.setText(displayOutput = Integer.toString(i.evaluate(infixExpression)));
				} catch (Exception UnsupportedOperationException) {
					calculatorDisplay.setText("ERROR");
				}
			}
		});
		Equals.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Equals.setBounds(105, 306, 85, 46);
		contentPane.add(Equals);

		// Exponent "^" button
		JButton Exponent = new JButton("^");
		Exponent.setBackground(Color.DARK_GRAY);
		Exponent.setForeground(Color.WHITE);
		Exponent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "^");
			}
		});
		Exponent.setFont(new Font("Open Sans", Font.PLAIN, 19));
		Exponent.setBounds(200, 306, 85, 46);
		contentPane.add(Exponent);

		// #0 button
		JButton Button0 = new JButton("0");
		Button0.setBackground(Color.WHITE);
		Button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "0");
			}
		});
		Button0.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button0.setBounds(10, 306, 85, 46);
		contentPane.add(Button0);

		// #1 button
		JButton Button1 = new JButton("1");
		Button1.setBackground(Color.WHITE);
		Button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "1");
			}
		});
		Button1.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button1.setBounds(10, 250, 85, 46);
		contentPane.add(Button1);

		// #2 button
		JButton Button2 = new JButton("2");
		Button2.setBackground(Color.WHITE);
		Button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "2");
			}
		});
		Button2.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button2.setBounds(105, 250, 85, 46);
		contentPane.add(Button2);

		// #3 button
		JButton Button3 = new JButton("3");
		Button3.setBackground(Color.WHITE);
		Button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "3");
			}
		});
		Button3.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button3.setBounds(200, 250, 85, 46);
		contentPane.add(Button3);

		// #4 button
		JButton Button4 = new JButton("4");
		Button4.setBackground(Color.WHITE);
		Button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "4");
			}
		});
		Button4.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button4.setBounds(10, 194, 85, 46);
		contentPane.add(Button4);

		// #5 button
		JButton Button5 = new JButton("5");
		Button5.setBackground(Color.WHITE);
		Button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "5");
			}
		});
		Button5.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button5.setBounds(105, 194, 85, 46);
		contentPane.add(Button5);

		// #6 button
		JButton Button6 = new JButton("6");
		Button6.setBackground(Color.WHITE);
		Button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "6");
			}
		});
		Button6.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button6.setBounds(200, 194, 85, 46);
		contentPane.add(Button6);

		// #7 button
		JButton Button7 = new JButton("7");
		Button7.setBackground(Color.WHITE);
		Button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "7");
			}
		});
		Button7.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button7.setBounds(10, 138, 85, 46);
		contentPane.add(Button7);

		// #8 button
		JButton Button8 = new JButton("8");
		Button8.setBackground(Color.WHITE);
		Button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "8");
			}
		});
		Button8.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button8.setBounds(105, 138, 85, 46);
		contentPane.add(Button8);

		// #9 button
		JButton Button9 = new JButton("9");
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button9.setBackground(Color.WHITE);
		Button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "9");
			}
		});
		Button9.setFont(new Font("Open Sans", Font.PLAIN, 18));
		Button9.setBounds(200, 138, 85, 46);
		contentPane.add(Button9);
	}
}
