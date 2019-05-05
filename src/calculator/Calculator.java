package calculator;

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
	Double memory = null;
	Double firstNum = null;
	Double secondNum = null;
	Double result = null;
	String operator = null;
	Boolean clearTextField = false;

	static String bAll[] = { "MC", "M+", "M-", "MR", "<-", "C", "%", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1",
			"2", "3", "/", ".", "0", "+/-", "=" };
	static Set<String> memoryBtn = Stream.of("MC", "M+", "M-", "MR").collect(Collectors.toSet());
	static Set<String> editBtn = Stream.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "<-", "+/-", "C")
			.collect(Collectors.toSet());
	static Set<String> operatorsBtn = Stream.of("+", "-", "*", "/", "%", "=").collect(Collectors.toSet());

	private JFrame fCalculator;
	private JTextField tField;
	private Button allBtn[] = new Button[bAll.length];;

	public Calculator() {

		fCalculator = new JFrame("Calculator");
		fCalculator.setBounds(450, 100, 245, 447);
		fCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fCalculator.setResizable(false);
		fCalculator.setLayout(null);

		tField = new JTextField("0");
		tField.requestFocusInWindow();
		tField.setBounds(0, 0, 240, 60);
		tField.setFont(new Font("Century Gothic", Font.PLAIN, 35));
		tField.setHorizontalAlignment(SwingConstants.RIGHT);
		tField.setCaretColor(Color.WHITE);
		tField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					inputOperator("=");
				if (key == KeyEvent.VK_BACK_SPACE)
					inputOperator("<-");
			}

			public void keyTyped(KeyEvent e) {
				tField.setCaretPosition(tField.getText().length());
				String str = String.valueOf(e.getKeyChar());
				if (editBtn.contains(str))
					inputInTextField(str);
				if (operatorsBtn.contains(str))
					inputOperator(str);
				e.consume();
			}
		});
		fCalculator.add(tField);

		for (int i = 0; i < bAll.length; i++) {
			int x = 0 + (i + 4) % 4 * 60;
			int y = 60 + (i / 4) * 60;

			allBtn[i] = new Button(bAll[i]);
			allBtn[i].setFont(new Font("Century Gothic", Font.PLAIN, 20));
			allBtn[i].setBounds(x, y, 60, 60);
			allBtn[i].setBackground(Color.WHITE);
			allBtn[i].setForeground(Color.DARK_GRAY);
			allBtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Button tmpBtn = (Button) arg0.getSource();
					String tmpStr = tmpBtn.getLabel();
					if (memoryBtn.contains(tmpStr))
						memoryBtn(tmpStr);
					if (editBtn.contains(tmpStr))
						inputInTextField(tmpStr);
					if (operatorsBtn.contains(tmpStr))
						inputOperator(tmpStr);
					tField.requestFocusInWindow();// постійний фокус на TextField
				}
			});
			fCalculator.getContentPane().add(allBtn[i]);
		}

		fCalculator.setVisible(true);
	}

	private void memoryBtn(String btnText) {

//		
//			Double dbl = Double.valueOf(tField.getText());
//	
//		switch (btnText) {
//		
//		
//		case "M+":
//			memory = memory + dbl;
//			break;
//			
//		case "M-":
//			memory = memory - dbl;
//			break;
//		case "MC":
//			memory = null;
//			break;
//		case "MR":
//			tField.setText(String.valueOf(memory));
//			break;
//		}
	}
	// ----- input 0..9, ".", "<-", "+/-", "C" -----------------------

	private void inputInTextField(String btnText) {

		if (clearTextField) {
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
			if (textField.equals("0"))
				textField = "";
			textField += btnText;
			break;

		case ".":
			if (!(textField.contains(".")))
				textField += btnText;
			break;

		case "<-":
			// 8 or -5 to 0
			if (textField.length() == 1 || ((textField.length() == 2) && (textField.charAt(0) == '-'))) {
				textField = "0";
				break;
			}
			// -11.5 to -11.
			if (textField.length() > 1) {
				textField = textField.substring(0, textField.length() - 1);
				break;
			}

		case "+/-":

			double dou = Double.valueOf(textField);
			textField = String.valueOf(-dou);
			textField = String.valueOf(firstNum);

			break;

		case "C":
			firstNum = null;
			secondNum = null;
			result = null;
			operator = null;
			clearTextField = false;
			textField = "0";
			break;
		}

		tField.setText(textField);
	}

	// ----- input +, -, *, /, %, = ------------------------

	void inputOperator(String btnText) {

		double tempNum = Double.parseDouble(tField.getText());

		switch (btnText) {
		case "=":
			outputEquals(btnText);
			break;

		case "+":
		case "-":
		case "*":
		case "/":

			// -------- не вистачає крду для вирахування при натисненні

			operator = btnText;
			firstNum = tempNum;
			secondNum = null;
			result = null;
			clearTextField = true;
			break;

		case "%":
			outputEquals(btnText);
			break;

		}
	}

	// ------- логіка розрахунків, математичні аперації
	void outputEquals(String btnText) {

		switch (btnText) {

		case "=":
			if (result == null) {
				secondNum = Double.valueOf(tField.getText());
				break;
			}
			if (result != null) {
				firstNum = result;
				break;
			}

		case "+":
		case "-":
		case "*":
		case "/":
			// ---------- вписати дії при зверненні операторів для виконання розрахунків і +

		case "%":
			if (firstNum != null && operator != null)
				secondNum = firstNum * Double.valueOf(tField.getText()) / 100;
			break;
		}

		if (firstNum != null && operator != null && secondNum != null)

		{

			clearTextField = true;

			switch (operator) {
			case "+":
				result = firstNum + secondNum;
				break;
			case "-":
				result = firstNum - secondNum;
				break;
			case "*":
				break;
			case "/":
				result = firstNum / secondNum;
				break;

//				if (operator == "/" && secondNum == 0) {
//					firstNum = null;
//					secondNum = null;
//					result = null;
//					operator = null;
//					clearTextField = true;
//					tField.setText("For 0 does not divide");
//					break;
//				}

			}

			firstNum = null;
			tField.setText("" + result);

		}
	}
}