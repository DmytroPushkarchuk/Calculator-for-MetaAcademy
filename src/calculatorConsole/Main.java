package calculatorConsole;

import java.util.Scanner;

import calculatorConsole.calculators.Calculator;
import calculatorConsole.calculators.FactoryCalculator;
import calculatorConsole.inputData.FactoryInput;
import calculatorConsole.inputData.Input;
import calculatorConsole.inputData.VersionInput;

public class Main extends Logic {

	public static void main(String[] args) {

		MyClass myClass = new MyClass();
		FactoryInput factoryInput = new FactoryInput();
		FactoryCalculator factoryCalculator = new FactoryCalculator();

		Scanner scanner = new Scanner(System.in);
		String str;
		
		VersionInput versionInput = null;

		do {
			System.out.println("Lite or Full? (1/2)");
			str = scanner.next();
			switch (str) {
			case "1":
				versionInput = VersionInput.LITE;
				break;
			case "2":
				versionInput = VersionInput.FULL;
				break;
			}
		} while (versionInput == null);
		
		Input input = factoryInput.createInput(versionInput);
		input.inputData(myClass);
		
		Calculator calculator = factoryCalculator.createCalculator(myClass.versionCalculator);
		calculator.calculation(myClass);

		scanner.close();
	}

}
