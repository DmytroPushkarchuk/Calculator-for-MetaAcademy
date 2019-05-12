package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class OneLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public OneLimit() {
		System.out.println(
				"Version: 'one operator with limits'\n\n"
				+ "  limits:\n" 
				+ "    0 <= Arabics numbs <= 10 \n"
				+ "    I <= Romans numbs <= X\n"
				+ "------------------------------------------------");
	}

	@Override
	public void inputData(Data data) {

		do {
			String str = null;
			String tmpStr = null;
			Boolean blnCorrect = true;

			System.out.print("please enter the first number:  ");
			tmpStr = scanner.next().toUpperCase();
			str = tmpStr.toUpperCase();
			if (!correctNumber(tmpStr)) {
				System.out.println("  number is NOT correct");
				blnCorrect = false;
			}

			System.out.print("please enter the operator:      ");
			tmpStr = scanner.next();
			str += tmpStr;
			if (!correctOperaror(tmpStr)) {
				System.out.println("operator is NOT correct");
				blnCorrect = false;
			}

			System.out.print("please enter the second number: ");
			tmpStr = scanner.next().toUpperCase();
			str += tmpStr;
			if (!correctNumber(tmpStr)) {
				System.out.println("   number is NOT correct");
				blnCorrect = false;
			}
			System.out.println();

			if (blnCorrect && typeCalculator(str) == null) {
				System.out.println(str + " is not correct! \n------------------------------------------------");
				data.versionCalculator = null;
			} else {
				data.versionCalculator = typeCalculator(str);
				data.mathExpression = str;
				
				System.out.println(data.mathExpression + " is " + data.versionCalculator + " expression\n"
						+ "------------------------------------------------");
			}

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
