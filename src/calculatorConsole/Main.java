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
		
		String str;

		Scanner scanner = new Scanner(System.in);
		
		VersionInput versionInput = null;

		do {
			System.out.println("Lite, Medium, NEW? (1/2/3)");
			str = scanner.next();
			switch (str) {
			case "1":
				versionInput = VersionInput.LITE;
				break;
			case "2":
				versionInput = VersionInput.MEDIUM;
				break;
			case "3":
				versionInput = VersionInput.NEW;
				break;
			}
			
		} while (versionInput == null);
		
		
		Input input = factoryInput.createInput(versionInput);
		input.inputData(data);
		
		Calculator calculator = factoryCalculator.createCalculator(data.versionCalculator);
		calculator.calculation(data);

		scanner.close();
	}

}
