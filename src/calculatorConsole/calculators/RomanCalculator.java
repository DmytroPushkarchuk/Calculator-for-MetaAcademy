package calculatorConsole.calculators;

import calculatorConsole.Logic;
import calculatorConsole.MyClass;

public class RomanCalculator extends Logic implements Calculator {

	@Override
	public void calculation(MyClass myClass) {
		
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
		
		System.out.println(myClass.first + " " + myClass.operator + " " + myClass.second + " = " +  convertArabicToRoman(result));

	}
		
}
