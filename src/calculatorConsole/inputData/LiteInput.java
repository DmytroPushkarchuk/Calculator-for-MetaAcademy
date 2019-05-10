package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.Data;
import calculatorConsole.calculators.VersionCalculator;

public class LiteInput extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public LiteInput() {
		System.out.println("Lite version \n" + 
				"  0 <= Arabics numbs <= 10 \n" + 
				"  I <= Romans numbs <= X\n");
	}

	@Override
	public void inputData(Data myClass) {

		do {

			System.out.print("please enter the first number:  ");
			myClass.first = scanner.next().toUpperCase();
			System.out.println(String.valueOf(correctData(myClass.first))+"\n");

			System.out.print("please enter the operator:      ");
			myClass.operator = scanner.next();
			System.out.println(String.valueOf(correctOperator(myClass.operator))+"\n");

			System.out.print("please enter the second number: ");
			myClass.second = scanner.next().toUpperCase();

			myClass.versionCalculator = typeCalculator(myClass.first, myClass.second, myClass.operator);
			System.out.println(String.valueOf(correctData(myClass.second))+"\n");
			
			if (myClass.versionCalculator == null) 
				System.out.println("incorrect data, try again \n");
				

		} while (myClass.versionCalculator == null);

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

		if (data.matches("[MDCLXVI]+")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt)) && (1 <= tmpInt && tmpInt <= 10)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public VersionCalculator typeCalculator(String first, String second, String operator) {

		if (correctData(first) && correctData(second) && correctOperator(operator)) {

			if ((first.matches("\\d+")) && (second.matches("\\d+"))) {
				return VersionCalculator.ARABIC;
			}

			if ((first.matches("[MDCLXVI]+")) && (second.matches("[MDCLXVI]+"))) {
				return VersionCalculator.ROMANIC;
			}
		}

		return null;
	}

}
