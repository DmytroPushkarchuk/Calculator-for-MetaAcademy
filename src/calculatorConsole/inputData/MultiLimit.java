package calculatorConsole.inputData;

import java.util.Scanner;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class MultiLimit extends Logic implements Input {

	Scanner scanner = new Scanner(System.in);

	public MultiLimit() {
		System.out.println(
				"Version: 'multi-operators with limits'\n" 
				+ "  limits:\n" 
				+ "    0 <= Arabics numbs <= 10 \n"
				+ "    I <= Romans numbs <= X\n"
				+ "  examples: 5*8-5/10 or V+IX*IX/II/I\n"
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
				System.out.println(strScanner + " is not correct! \n");
			}
			System.out.println("------------------------------------------------");
		} while (data.versionCalculator == null);
		
	}

	@Override
	public Boolean correctNumber(String data) {
		int tmpInt;

		if (data.matches("\\d+"))
//			ліміти арабських чисел
			if (Integer.valueOf(data) >= 0 && Integer.valueOf(data) <= 10)
				return true;

		if (data.matches("[MDCLXVI]+")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt)))
//				ліміти римських чисел
				if (tmpInt >= 1 && tmpInt <= 10)
					return true;
		}

		return false;
	}

}