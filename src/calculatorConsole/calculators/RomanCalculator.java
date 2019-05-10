package calculatorConsole.calculators;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class RomanCalculator extends Logic implements Calculator {

	@Override
	public void calculation(Data myClass) {
		
		int firstNub = convertRomanToArabic(myClass.first);
		int secondNum = convertRomanToArabic(myClass.second);
		int result = 0;

		switch (myClass.operator) {
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
		
//		if (myClass.operator.equals("/") && secondNum == 0) {
//			System.out.println(
//					myClass.first + " " + myClass.operator + " " + myClass.second + " = for 0 does not divide");
//		} else {
//			System.out.println(
//					myClass.first + " " + myClass.operator + " " + myClass.second + " = " + String.valueOf(result));
//		}
		
		
		
		System.out.println(myClass.first + " " + myClass.operator + " " + myClass.second + " = " +  convertArabicToRoman(result));

	}
		
}
