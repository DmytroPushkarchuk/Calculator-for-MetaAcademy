package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import calculatorConsole.Logic;

public class RomanCalculator extends AbstractCalculator {

	Logic logic = new Logic();

	@Override
	public void calculation(String expression) {

		List<String> operators = new LinkedList<String>(Arrays.asList(expression.split("[MDCLXVI0-9]+")));

//		з виразу вибирає всі римські числа і конвертує їх цілі числа
		List<Integer> numbers = new LinkedList<Integer>(
				Arrays.asList(expression.split("[+*/-]"))
				.stream()
				.map(logic::convertRomanToArabic)
				.collect(Collectors.toList()));
		
//		отримання результату
		Integer value = result(numbers, operators);
		
		if (value != null) 
			System.out.println(expression + "=" + logic.convertArabicToRoman(value));
		
	}

}