package calculatorConsole.calculators;

import calculatorConsole.Logic;
import calculatorConsole.MyClass;

public class ArabicCalkulator extends Logic implements Calculator {

	public void calculation(MyClass myClass) {

		int firstNub = Integer.valueOf(myClass.first);
		int secondNum = Integer.valueOf(myClass.second);
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
			if (secondNum == 0)
//				 return "�� 0 ���������!";
			result = firstNub / secondNum;
			break;
		}
		
		System.out.println(myClass.first + " " + myClass.operator + " " + myClass.second + " = " +  String.valueOf(result));

	}
}