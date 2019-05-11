package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class MultiLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public MultiLimit() {
		System.out.println("Version: 'multi-opn erators with limits'\n\n"
				+ "  limits:\n" 
				+ "    0 <= Arabics numbs <= 10 \n"
				+ "    I <= Romans numbs <= X\n"
				+ "  examples:\n"
				+ "    2+5*8-5/10\n"
				+ "    V-I*IX+II/I\n"
				+ "  is not case-sensitive and space\n"
				+ "------------------------------------------------");
	}

	@Override
	public void inputData(Data data) {
		String tmpStr;
		do {
			System.out.print("Enter an expression: ");
			tmpStr = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
			System.out.println();
			
		
			
			if (typeCalculator(tmpStr) != null) {
				data.versionCalculator = typeCalculator(tmpStr);
				data.matheExpression = tmpStr;

				System.out.println(data.matheExpression + " is " + data.versionCalculator + " expression\n"
						+ "------------------------------------------------");
			} else {
				System.out.println(tmpStr + " is not correct! \n" + "------------------------------------------------");
				data.versionCalculator = null;
			}
		} while (data.versionCalculator == null);

	}

	@Override
	public Boolean correctNumber(String data) {
		int tmpInt;

		if (data.matches("\\d+"))
			if (Integer.valueOf(data) >= 0 && Integer.valueOf(data) <= 10) 
				return true;

		if (data.matches("[MDCLXVI]+")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt))) 
				if (tmpInt >= 1 && tmpInt <= 10) 
					return true;
		}

		return false;
	}

}