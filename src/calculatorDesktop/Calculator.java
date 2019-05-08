package calculatorDesktop;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {

	// ---- wrapper class for logical operations
	private Double firstNum = null;
	private Double secondNum = null;
	private Double result = null;
	private String operator = null;
	private Boolean clearTextField = false;
	// Boolean firstOper = true;

	private Double memory = null;

	static String textBtnAll[] = { "MC", "M+", "M-", "MR", "<-", "C", "%", "+", "7", "8", "9", "-", "4", "5", "6", "*",
			"1", "2", "3", "/", ".", "0", "+/-", "=" };
	static Set<String> memoryBtn = Stream.of("MC", "M+", "M-", "MR").collect(Collectors.toSet());
	static Set<String> operatorsBtn = Stream.of("+", "-", "*", "/", "%", "=").collect(Collectors.toSet());
	static Set<String> editBtn = Stream.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "<-", "+/-", "C")
			.collect(Collectors.toSet());

	private JFrame fCalculator;
	private JTextField tField;
	private Button arrBtn[] = new Button[textBtnAll.length];
//	private JLabel lbMemory;

//----------------------------------------------------------------------------------------------- create forms

	public Calculator() {

		fCalculator = new JFrame("Calculator");
		fCalculator.setBounds(450, 100, 245, 447);
		fCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fCalculator.setResizable(false);
		fCalculator.setLayout(null);

//		lbMemory = new JLabel("M");
//		lbMemory.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lbMemory.setBounds(0, 0, 25, 25);
//		lbMemory.setHorizontalAlignment(SwingConstants.RIGHT);
//		lbMemory.setVerticalAlignment(SwingConstants.TOP);
//		lbMemory.setVisible(true);
//		fCalculator.add(lbMemory);

		tField = new JTextField("0");
		tField.requestFocusInWindow();
		tField.setBounds(0, 0, 240, 60);
		tField.setFont(new Font("Century Gothic", Font.PLAIN, 35));
		tField.setHorizontalAlignment(SwingConstants.RIGHT);
		tField.setCaretColor(Color.WHITE);
		tField.addKeyListener(new KeyAdapter() {

			// keyboard input Enter, Backspace
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_BACK_SPACE)
					inputInTextField("<-");
				if (key == KeyEvent.VK_ENTER)
					inputOperator("=");
				e.consume();
			}

			// keyboard input 0..9, +, -, *, /, =
			public void keyTyped(KeyEvent e) {
				tField.setCaretPosition(tField.getText().length());
				String btnText = String.valueOf(e.getKeyChar());
				if (editBtn.contains(btnText))
					inputInTextField(btnText);
				if (operatorsBtn.contains(btnText))
					inputOperator(btnText);
				e.consume();
			}
		});
		fCalculator.add(tField);

		// initialization Button
		for (int i = 0; i < textBtnAll.length; i++) {
			int x = 0 + (i + 4) % 4 * 60;
			int y = 60 + (i / 4) * 60;
			arrBtn[i] = new Button(textBtnAll[i]);
			arrBtn[i].setFont(new Font("Century Gothic", Font.PLAIN, 20));
			arrBtn[i].setBounds(x, y, 60, 60);
			arrBtn[i].setBackground(Color.WHITE);
			arrBtn[i].setForeground(Color.DARK_GRAY);
			arrBtn[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Button tmpBtn = (Button) e.getSource();
					String btnText = tmpBtn.getLabel();
					if (memoryBtn.contains(btnText))
						memoryBtn(btnText);
					if (editBtn.contains(btnText))
						inputInTextField(btnText);
					if (operatorsBtn.contains(btnText))
						inputOperator(btnText);

					// foces on TextFile
					tField.requestFocusInWindow();
				}
			});
			fCalculator.getContentPane().add(arrBtn[i]);
		}

		fCalculator.setVisible(true);
	}

//------------------------------------------------------------------------------------------- work with Memory

	private void memoryBtn(String btnText) {

		if (memory == null) {
			memory = (double) 0;
		}

		Double valueTextField = Logic.convertTextToDouble(tField.getText());

		switch (btnText) {

		case "M+":
			memory = memory + valueTextField;
//			lbMemory.setVisible(true);
			break;
		case "M-":
			memory = memory - valueTextField;
//			lbMemory.setVisible(true);
			break;
		case "MR":
			tField.setText(Logic.convertDoubleToText(memory));
			break;
		case "MC":
			memory = null;
//			lbMemory.setVisible(false);
			break;
		}
	}

// ------------------------------------------------------------------------- input 0..9, ".", "<-", "+/-", "C" 

	private void inputInTextField(String btnText) {

		if (clearTextField && (!(btnText.equals("+/-")) && !(btnText.equals("<-")))) {
			tField.setText("");
			clearTextField = false;
		}

		String textField = tField.getText();

		switch (btnText) {

		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
//			firstOper = true;
			if (textField.equals("0"))
				textField = "";
			textField += btnText;
			break;

		case ".":
			if (!(textField.contains(".")))
				textField += btnText;
			break;

		case "<-":
			if (textField.equals("-0.") || (textField.equals("Infinity")) || textField.length() == 1) {
				textField = "0";
				break;
			}
			if ((textField.length() == 2) && (textField.charAt(0) == '-')) {
				textField = "0";
				break;
			}
			if (textField.length() > 1) {
				textField = textField.substring(0, textField.length() - 1);
				break;
			}

		case "C":
			firstNum = null;
			secondNum = null;
			result = null;
			operator = null;
			clearTextField = false;
			textField = "0";
			break;

		case "+/-":
			if (!(textField.equals("0"))) {
				if (textField.charAt(0) == '-')
					textField = textField.substring(1);
				else
					textField = "-" + textField;
			}
			break;
		}

		tField.setText(textField);

	}

// ------------------------------------------------------------------------------------ input +, -, *, /, %, = 

	private void inputOperator(String btnText) {

		double valueTextField = Logic.convertTextToDouble(tField.getText());

		switch (btnText) {
		case "+":
		case "-":
		case "*":
		case "/":

//			if (firstNum != null && result == null && firstOper) {
//				outputEquals(btnText);
//				firstOper = false;
//			}

			firstNum = valueTextField;
			operator = btnText;
			secondNum = null;
			result = null;
			clearTextField = true;
			break;

		case "%":
			if (firstNum != null && operator != null)
				secondNum = firstNum * valueTextField / 100;

			result = Logic.outputEquals(firstNum, secondNum, operator);
			tField.setText(Logic.convertDoubleToText(result));
			clearTextField = true;
			firstNum = null;
			break;

		case "=":
			if (firstNum == null && secondNum == null) {
				break;
			}
			if (result == null) {
				secondNum = valueTextField;
			} else {
				firstNum = result;
			}

			result = Logic.outputEquals(firstNum, secondNum, operator);
			tField.setText(Logic.convertDoubleToText(result));
			clearTextField = true;
			firstNum = null;
			break;
		}
	}

}
