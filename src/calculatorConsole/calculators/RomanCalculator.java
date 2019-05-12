package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class RomanCalculator extends AbstractCalculator {

	Logic logic = new Logic();

	public void calculation(Data data) {

//		з виразу вибирає всі оператори
		List<String> operators = new LinkedList<String>(Arrays.asList(data.mathExpression.split("[MDCLXVI0-9]+")));

//		з виразу вибирає всі римські числа і конвертує їх цілі числа
		List<Integer> numbers = new LinkedList<Integer>(
				Arrays.asList(data.mathExpression.split("[+*/-]"))
				.stream()
				.map(logic::convertRomanToArabic)
				.collect(Collectors.toList()));
		
//		отримання результату
		Integer value = result(numbers, operators);
		
		if (value != null) 
			System.out.println(data.mathExpression + "=" + logic.convertArabicToRoman(value));
		
	}

}