package calculatorConsole;

import java.util.Scanner;

import calculatorConsole.calculators.Calculator;
import calculatorConsole.calculators.FactoryCalculator;
import calculatorConsole.inputData.FactoryInput;
import calculatorConsole.inputData.Input;
import calculatorConsole.inputData.VersionInput;

public class Main extends Logic {

	public static void main(String[] args) {

		FactoryInput factoryInput = new FactoryInput();
		FactoryCalculator factoryCalculator = new FactoryCalculator();

		Scanner scanner = new Scanner(System.in);

		String str;
		VersionInput verInp = null;

		do {
			System.out.println("Lite or Full? (1/2)");
			str = scanner.next();
			switch (str) {
			case "1":
				verInp = VersionInput.LITE;
				break;
			case "2":
				verInp = VersionInput.FULL;
				break;
			}

		} while (verInp == null);

		Input input = factoryInput.createInput(verInp);

		MyClass myClass = input.inputData();

		scanner.close();

		Calculator calculator = factoryCalculator.createCalculator(myClass.varCalc);

		System.out.println(calculator.calculation(myClass.first, myClass.operator, myClass.second));

	}

}
