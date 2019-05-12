package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class OneNotLimit extends Logic implements Input {
	Data myClass = new Data();
	Scanner scanner = new Scanner(System.in);

	public OneNotLimit() {
		System.out.println(
				"Version: 'one operator without limits'\n" + "------------------------------------------------");
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

}
