package calculatorConsole;

import java.util.Scanner;

import calculatorConsole.calculators.Calculator;
import calculatorConsole.calculators.FactoryCalculator;
import calculatorConsole.inputData.FactoryInput;
import calculatorConsole.inputData.Input;
import calculatorConsole.inputData.VersionInput;

public class Main {

	public static void main(String[] args) {

		Data data = new Data();
		FactoryInput factoryInput = new FactoryInput();
		FactoryCalculator factoryCalculator = new FactoryCalculator();

		String str = null;
		Scanner scanner = new Scanner(System.in);

		do {
			VersionInput versionInput = null;
			do {
				System.out.print("\nVersions calculators:\n\n"
						+ "  'one operator with limits'        (1)\n"
						+ "  'one operator without limits'     (2)\n"
						+ "  'multi-operators with limits'     (3)\n"
						+ "  'multi-operators without limits'  (4)\n\n"
						+ "select your version: ");
				str = scanner.next();
				switch (str) {
				case "1":
					versionInput = VersionInput.MULTI_LIMIT;
					break;
				case "2":
					versionInput = VersionInput.ONE_NO_LIMIT;
					break;
				case "3":
					versionInput = VersionInput.MULTI_LIMIT;
					break;
				case "4":
					versionInput = VersionInput.MULTI_NO_LIMIT;
					break;
				default: System.out.println("------------------------------------------------"
						+ "\nInvalid key, try again!");
				}

				System.out.println("------------------------------------------------");
			} while (versionInput == null);

			Input input = factoryInput.createInput(versionInput);
			input.inputData(data);

			Calculator calculator = factoryCalculator.createCalculator(data.versionCalculator);
			calculator.calculation(data);

			System.out.println("\nquit the program? (Y/N)");
			str = scanner.next().toUpperCase();

		} while (!str.equals("Y"));

		scanner.close();
	}

}
