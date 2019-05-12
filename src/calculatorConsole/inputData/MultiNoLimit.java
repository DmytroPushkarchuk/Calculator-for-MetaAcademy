package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class MultiNoLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public MultiNoLimit() {
		System.out.println(
				"Version: 'multi-operators without limits'\n\n"
				+ "  examples:\n"
				+ "    225+5589*8-565/10\n"
				+ "    LXV+C*IX+LXXIV/I*IV\n"
				+ "  not sensitive to lowercase and space\n"
				+ "------------------------------------------------");
	}

	@Override
	public void inputData(Data data) {
		String tmpStr;
		do {
			System.out.print("Enter an expression: ");
			tmpStr = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
			System.out.println();

			if (typeCalculator(tmpStr) == null) {
				data.versionCalculator = null;
				System.out.println(tmpStr + " is not correct! \n------------------------------------------------");
			} else {
				data.versionCalculator = typeCalculator(tmpStr);
				data.matheExpression = tmpStr;
				System.out.println(data.matheExpression + " is " + data.versionCalculator
						+ " expression\n------------------------------------------------");
			}
		} while (data.versionCalculator == null);

	}

}
