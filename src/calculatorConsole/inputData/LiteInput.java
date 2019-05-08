package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.MyClass;
import calculatorConsole.calculators.VarietyCalculator;

public class LiteInput extends Logic implements Input {

	public LiteInput() {
		System.out.println("Lite version \n  0 <= Arabics numbs <= 10 \n  I <= Romanian numbs <= X");
	}

	MyClass myClass = new MyClass();
	Scanner scanner = new Scanner(System.in);

	@Override
	public MyClass inputData() {

		do {

			System.out.println("please enter the first number");
			myClass.first = scanner.next();
			System.out.println(String.valueOf(correctData(myClass.first)));

			System.out.println("please enter the operator");
			myClass.operator = scanner.next();
			System.out.println(String.valueOf(correctOperator(myClass.operator)));

			System.out.println("please enter the second number");
			myClass.second = scanner.next();
			System.out.println(String.valueOf(correctData(myClass.second)));

			myClass.varCalc = typeCalculator(myClass.first, myClass.second, myClass.operator);

		} while (myClass.varCalc == null);
		
		return myClass;
	}

	@Override
	public Boolean correctData(String data) {

		int tmpInt;

		if (data.matches("\\d+")) {
			tmpInt = Integer.valueOf(data);
			if (0 <= tmpInt && tmpInt <= 10) {
				return true;
			}
		}

		if (data.matches("[M,D,C,L,X,V,I]")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt)) && (1 <= tmpInt && tmpInt <= 10)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public VarietyCalculator typeCalculator(String first, String second, String operator) {

		if (correctData(first) && correctData(second) && correctOperator(operator)) {

			if ((first.matches("\\d+")) && (second.matches("\\d+"))) {
				return VarietyCalculator.ARABIC;
			}

			if (((first.matches("[M,D,C,L,X,V,I]")) && (second.matches("[M,D,C,L,X,V,I]")))) {
				return VarietyCalculator.ROMANIC;
			}

		}
		return null;
	}

}
