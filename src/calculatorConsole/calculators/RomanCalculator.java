package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class RomanCalculator extends AbstractCalculator {

	Logic logic = new Logic();

	public void calculation(Data data) {

		List<String> operators = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[MDCLXVI0-9]+")));

		List<String> tmpNumbs = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[+*/-]")));

		List<Integer> numbers = new LinkedList<Integer>();

		for (int i = 0; i < tmpNumbs.size(); i++)
			numbers.add(logic.convertRomanToArabic(tmpNumbs.get(i)));

		System.out.println(data.matheExpression + "=" + logic.convertArabicToRoman(result(numbers, operators)));
	}

}
