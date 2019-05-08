package calculatorConsole.calculators;

import calculatorConsole.Logic;

public class RomanCalculator extends Logic implements Calculator {

	@Override
	public String calculation(String first, String operator, String second) {
		
		int firstNub = convertRomanToArabic(first);
		int secondNum = convertRomanToArabic(second);
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
			result = firstNub / secondNum;
			break;
		}
		return first + " " + operator + " " + second + " = " +  convertArabicToRoman(result);

	}
		
}
