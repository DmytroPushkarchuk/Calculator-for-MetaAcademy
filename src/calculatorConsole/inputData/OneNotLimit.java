package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class OneNotLimit extends Logic implements Input {
	
	Scanner scanner = new Scanner(System.in);

	public OneNotLimit() {
		System.out.println(
				"Version: 'one operator without limits'" 
				+ "------------------------------------------------");
	}

	@Override
	public void inputData(Data data) {
		do {
			String str = null;
			String strScanner = null;
			Boolean b = true;

			System.out.print("please enter the first number:  ");
			strScanner = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
			str = strScanner;
			if (!correctNumber(strScanner)) {
				System.out.println("  number is NOT correct");
				b = false;
			}

			System.out.print("please enter the operator:      ");
			strScanner = scanner.nextLine().replaceAll("\\s+", "");
			str += strScanner;
			if (!correctOperator(strScanner)) {
				System.out.println("  operator is NOT correct");
				b = false;
			}

			System.out.print("please enter the second number: ");
			strScanner = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
			str += strScanner;
			if (!correctNumber(strScanner)) {
				System.out.println("  number is NOT correct");
				b = false;
			}

			data.versionCalculator = typeCalculator(str);
			
			if (b && data.versionCalculator != null) {
				data.mathExpression = str;
			} else {
				data.versionCalculator = null;
				System.out.println(str + " is not correct!");
			}
			System.out.println("------------------------------------------------");

		} while (data.versionCalculator == null);
	}

}
