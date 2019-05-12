package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import calculatorConsole.Data;

public class ArabicCalkulator extends AbstractCalculator {

	public void calculation(Data data) {

//		з виразу вибирає всі оператори		
		List<String> operators = new LinkedList<String>(Arrays.asList(data.mathExpression.split("[MDCLXVI0-9]+")));
		
//		з виразу вибирає всі арабські числа і конверту їх цілі числа
		List<Integer> numbers = new LinkedList<Integer>(
				Arrays.asList(data.mathExpression.split("[+*/-]"))
				.stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList()));
		
//		отримання результату
		Integer value = result(numbers, operators);
		
		if (value != null) 
			System.out.println(data.mathExpression + "=" + value);	
	}

}