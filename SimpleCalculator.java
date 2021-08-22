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
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		calculatorDisplay = new JTextField();
		calculatorDisplay.setForeground(new Color(255, 255, 0));
		calculatorDisplay.setBackground(Color.BLUE);
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
		calculatorDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		calculatorDisplay.setBounds(10, 10, 370, 62);
		contentPane.add(calculatorDisplay);
		calculatorDisplay.setColumns(10);

		JButton openBracket = new JButton("(");
		openBracket.setBackground(Color.GREEN);
		openBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "(");
			}
		});
		openBracket.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		openBracket.setBounds(10, 82, 85, 46);
		contentPane.add(openBracket);

		JButton closeBracket = new JButton(")");
		closeBracket.setBackground(Color.GREEN);
		closeBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + ")");
			}
		});
		closeBracket.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		closeBracket.setBounds(105, 82, 85, 46);
		contentPane.add(closeBracket);

		JButton backspace = new JButton("B");
		backspace.setBackground(Color.GREEN);
		backspace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput.substring(0, displayOutput.length() - 1));
			}
		});
		backspace.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		backspace.setBounds(200, 82, 85, 46);
		contentPane.add(backspace);

		JButton clear = new JButton("CE");
		clear.setBackground(Color.RED);
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = "");
			}
		});
		clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		clear.setBounds(295, 82, 85, 46);
		contentPane.add(clear);

		JButton Button7 = new JButton("7");
		Button7.setBackground(Color.CYAN);
		Button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "7");
			}
		});
		Button7.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button7.setBounds(10, 138, 85, 46);
		contentPane.add(Button7);

		JButton Button8 = new JButton("8");
		Button8.setBackground(Color.CYAN);
		Button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "8");
			}
		});
		Button8.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button8.setBounds(105, 138, 85, 46);
		contentPane.add(Button8);

		JButton Button9 = new JButton("9");
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button9.setBackground(Color.CYAN);
		Button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "9");
			}
		});
		Button9.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button9.setBounds(200, 138, 85, 46);
		contentPane.add(Button9);

		JButton Multiply = new JButton("*");
		Multiply.setBackground(Color.GREEN);
		Multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "*");
			}
		});
		Multiply.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Multiply.setBounds(295, 138, 85, 46);
		contentPane.add(Multiply);

		JButton Button4 = new JButton("4");
		Button4.setBackground(Color.CYAN);
		Button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "4");
			}
		});
		Button4.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button4.setBounds(10, 194, 85, 46);
		contentPane.add(Button4);

		JButton Button5 = new JButton("5");
		Button5.setBackground(Color.CYAN);
		Button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "5");
			}
		});
		Button5.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button5.setBounds(105, 194, 85, 46);
		contentPane.add(Button5);

		JButton Button6 = new JButton("6");
		Button6.setBackground(Color.CYAN);
		Button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "6");
			}
		});
		Button6.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button6.setBounds(200, 194, 85, 46);
		contentPane.add(Button6);

		JButton Divide = new JButton("/");
		Divide.setBackground(Color.GREEN);
		Divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "/");
			}
		});
		Divide.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Divide.setBounds(295, 194, 85, 46);
		contentPane.add(Divide);

		JButton Button1 = new JButton("1");
		Button1.setBackground(Color.CYAN);
		Button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "1");
			}
		});
		Button1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button1.setBounds(10, 250, 85, 46);
		contentPane.add(Button1);

		JButton Button2 = new JButton("2");
		Button2.setBackground(Color.CYAN);
		Button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "2");
			}
		});
		Button2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button2.setBounds(105, 250, 85, 46);
		contentPane.add(Button2);

		JButton Button3 = new JButton("3");
		Button3.setBackground(Color.CYAN);
		Button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "3");
			}
		});
		Button3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button3.setBounds(200, 250, 85, 46);
		contentPane.add(Button3);

		JButton Add = new JButton("+");
		Add.setBackground(Color.GREEN);
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "+");
			}
		});
		Add.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Add.setBounds(295, 250, 85, 46);
		contentPane.add(Add);

		JButton Button0 = new JButton("0");
		Button0.setBackground(Color.CYAN);
		Button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "0");
			}
		});
		Button0.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Button0.setBounds(10, 306, 85, 46);
		contentPane.add(Button0);

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

		Equals.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Equals.setBounds(105, 306, 85, 46);
		contentPane.add(Equals);

		JButton Exponent = new JButton("^");
		Exponent.setBackground(Color.GREEN);
		Exponent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "^");
			}
		});
		Exponent.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Exponent.setBounds(200, 306, 85, 46);
		contentPane.add(Exponent);

		JButton Subtract = new JButton("-");
		Subtract.setBackground(Color.GREEN);
		Subtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculatorDisplay.setText(displayOutput = displayOutput + "-");
			}
		});
		Subtract.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		Subtract.setBounds(295, 306, 85, 46);
		contentPane.add(Subtract);
	}
}
