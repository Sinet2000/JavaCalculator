import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, extractButton, multiplyButton, divideButton;
	JButton decimalButton, equalityButton, deleteButton, clearButton, negButton;
	JPanel panel;
	
	Font appFont = new Font("TimesRoman", Font.BOLD, 30);
	
	double num1 =0, num2=0, result = 0;
	char operator;
	
	public Calculator() {
		frame = new JFrame("Java Calkulators");
		
		//allows to close the program
		//relating to frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,600);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 25, 380, 50);
		textField.setFont(appFont);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		extractButton = new JButton("-");
		divideButton = new JButton("/");
		multiplyButton = new JButton("*");
		decimalButton= new JButton(".");
		equalityButton = new JButton("=");
		deleteButton = new JButton("Del");
		clearButton = new JButton("Clear");
		negButton = new JButton("Neg");
		
		functionButtons[0] = addButton;
		functionButtons[1] = extractButton;
		functionButtons[2] = divideButton;
		functionButtons[3] = multiplyButton;
		functionButtons[4] = decimalButton;
		functionButtons[5] = equalityButton;
		functionButtons[6] = deleteButton;
		functionButtons[7] = clearButton;
		functionButtons[8] = negButton;
		
		for(int i=0; i< functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(appFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i=0; i< numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(appFont);
			numberButtons[i].setFocusable(false);
		}
		
		deleteButton.setBounds(20, 480, 120, 50);
		clearButton.setBounds(160, 480, 120, 50);
		negButton.setBounds(300, 480, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(20, 100, 380, 350);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(new Color(239, 211, 211));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(extractButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplyButton);
		panel.add(decimalButton);
		panel.add(numberButtons[0]);
		panel.add(equalityButton);
		panel.add(divideButton);
		
		frame.add(panel);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(negButton);
		frame.add(textField);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i< numberButtons.length; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decimalButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if(e.getSource() == extractButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if(e.getSource() == multiplyButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if(e.getSource() == divideButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if(e.getSource() == equalityButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			default:
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clearButton) {
			textField.setText("");
		}
		
		if(e.getSource() == deleteButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i =0; i<string.length()-1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
			
		}
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}

}
