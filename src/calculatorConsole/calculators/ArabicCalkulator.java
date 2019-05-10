package calculatorConsole.calculators;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class ArabicCalkulator extends Logic implements Calculator {

	public void calculation(Data myClass) {

		long firstNub = Integer.valueOf(myClass.first);
		long secondNum = Integer.valueOf(myClass.second);
		long result = 0L;

		switch (myClass.operator) {
		case "+":
			result = (firstNub + secondNum);
			break;
		case "-":
			result = (firstNub - secondNum);
			break;
		case "*":
			result =  (firstNub * secondNum);
			break;
		case "/":
			if (secondNum != 0) {
				result = (firstNub / secondNum);
			}
			break;
		}

		if (myClass.operator.equals("/") && secondNum == 0) {
			System.out.println(
					myClass.first + " " + myClass.operator + " " + myClass.second + " = for 0 does not divide");
		} else {
			System.out.println(
					myClass.first + " " + myClass.operator + " " + myClass.second + " = " + String.valueOf(result));
		}

	}
}