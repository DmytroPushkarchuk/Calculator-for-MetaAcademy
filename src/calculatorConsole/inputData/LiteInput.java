package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Logic;
import calculatorConsole.Data;

public class LiteInput extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public LiteInput() {
		System.out.println("Lite version \n" + 
				"  0 <= Arabics numbs <= 10 \n" + 
				"  I <= Romans numbs <= X\n");
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
