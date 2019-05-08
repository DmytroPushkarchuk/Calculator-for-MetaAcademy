package calculatorConsole.calculators;

import calculatorConsole.Logic;

public class ArabicCalkulator extends Logic implements Calculator {

	public String calculation(String first, String operator, String second) {

		int firstNub = Integer.valueOf(first);
		int secondNum = Integer.valueOf(second);
		int result = 0;

		switch (operator) {
		case "+":
			result = firstNub + secondNum;
			break;
		case "-":
			result = firstNub - secondNum;
			break;
		case "*":
			result = firstNub * secondNum;
			break;
		case "/":
			if (secondNum == 0)
				return "�� 0 ���������!";
			result = firstNub / secondNum;
			break;
		}
		return first + " " + operator + " " + second + " = " +  String.valueOf(result);

	}
}