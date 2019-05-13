package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class MultiNoLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public MultiNoLimit() {
		System.out.println(
				"Version: 'multi-operators without limits'\n"
				+ "  examples: 225+589*8-565/10 or C*IX+LXXIV/I*IV\n"
				+ "  not sensitive to case and space\n"
				+ "------------------------------------------------");
	}

	@Override
	public void inputData(Data data) {
		String strScanner;
		do {
			System.out.print("Enter an expression: ");
			strScanner = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");

			data.versionCalculator = typeCalculator(strScanner);
			
			if (data.versionCalculator != null) {
				data.mathExpression = strScanner;
			} else {
				System.out.println(strScanner + " is not correct!");
			}
			System.out.println("------------------------------------------------");
		} while (data.versionCalculator == null);
	}

}
