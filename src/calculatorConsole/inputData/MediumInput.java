package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class MediumInput extends Logic implements Input {
	Data myClass = new Data();
	Scanner scanner = new Scanner(System.in);

	public MediumInput() {
		System.out.println("Medium version \n" + " -2147483648 <= Arabics numbs <= 2147483647\n"
				+ "  Romanian numbs (num1 * num2 <= 3999)");
	}

	@Override
	public void inputData(Data myClass) {
		do {

			System.out.print("please enter the first number:  ");
			myClass.first = scanner.next().toUpperCase();
			System.out.println(String.valueOf(correctData(myClass.first)) + "\n");

			System.out.print("please enter the operator:      ");
			myClass.operator = scanner.next();
			System.out.println(String.valueOf(correctOperator(myClass.operator)) + "\n");

			System.out.print("please enter the second number: ");
			myClass.second = scanner.next().toUpperCase();

			myClass.versionCalculator = typeCalculator(myClass.first, myClass.second, myClass.operator);
			System.out.println(String.valueOf(correctData(myClass.second)) + "\n");

			if (myClass.versionCalculator == null)
				System.out.println("incorrect data, try again \n");

		} while (myClass.versionCalculator == null);

	}

}
