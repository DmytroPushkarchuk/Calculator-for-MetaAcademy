package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class OneLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public OneLimit() {
		System.out.println(
				"Version: 'one operator with limits'\n"
				+ "  limits:\n" 
				+ "    0 <= Arabics numbs <= 10 \n"
				+ "    I <= Romans numbs <= X\n"
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

	@Override
	public Boolean correctNumber(String data) {
		int tmpInt;

		if (data.matches("\\d+"))
			if (Integer.valueOf(data) >= 0 && Integer.valueOf(data) <= 10)
				return true;

		if (data.matches("[MDCLXVI]+")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt)))
				if (tmpInt >= 1 && tmpInt <= 10)
					return true;
		}

		return false;
	}

}
