package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class NewInput extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public NewInput() {
		System.out.println("Example : 2 * 6 + 2 / 1");

	}

	@Override
	public void inputData(Data data) {
		String tmpStr;
		do {
			System.out.print("¬вед≥ть вираз: ");
			tmpStr = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
			data.matheExpression = tmpStr;
			data.versionCalculator = typeCalculator(tmpStr);
			System.out.println(data.versionCalculator);
		} while (data.versionCalculator == null);

	}

}
