package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class MediumInput extends Logic implements Input {
	Data myClass = new Data();
	Scanner scanner = new Scanner(System.in);

	public MediumInput() {
		System.out.println("Medium version \n" + " -2147483648 <= Arabics numbs <= 2147483647\n"
				+ "  Romanian numbs (num1 * num2 <= 3999)");
	}

	@Override
	public void inputData(Data data) {
		do {
			String str = null;
			String tmpStr = null;

			System.out.print("please enter the first number:  ");
			tmpStr = scanner.next().toUpperCase();
			str = tmpStr;
			System.out.println(correctNumber(tmpStr) + "\n");

			System.out.print("please enter the operator:      ");
			tmpStr = scanner.next();
			System.out.println(correctOperaror(tmpStr) + "\n");
			str += tmpStr;

			System.out.print("please enter the second number: ");
			tmpStr = scanner.next().toUpperCase();
			System.out.println(correctNumber(tmpStr) + "\n");
			str += tmpStr;
			
			data.matheExpression = str;
			
			data.versionCalculator = typeCalculator(tmpStr);
			System.out.println(data.versionCalculator);
			System.out.println(data.matheExpression);

		} while (data.versionCalculator == null);

	}

}
