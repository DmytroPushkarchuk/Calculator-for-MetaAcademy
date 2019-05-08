package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.MyClass;

public class FullInput extends Logic implements Input {
	MyClass myClass = new MyClass();
	Scanner input = new Scanner(System.in);

	public FullInput() {
		System.out.println("Full version");
	}

	@Override
	public MyClass inputData() {
		do {

			System.out.println("please enter the first number");
			myClass.first = input.next();
			System.out.println(String.valueOf(correctData(myClass.first)));

			System.out.println("please enter the operator");
			myClass.operator = input.next();
			System.out.println(String.valueOf(correctOperator(myClass.operator)));

			System.out.println("please enter the second number");
			myClass.second = input.next();
			System.out.println(String.valueOf(correctData(myClass.second)));

			myClass.varCalc = typeCalculator(myClass.first, myClass.second, myClass.operator);

		} while (myClass.varCalc == null);

		return myClass;
	}

}
