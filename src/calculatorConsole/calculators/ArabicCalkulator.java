package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import calculatorConsole.Data;

public class ArabicCalkulator extends AbstractCalculator {

	public void calculation(Data data) {

		List<String> operators = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[MDCLXVI0-9]+")));

		List<String> tmpNumbs = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[+*/-]")));

		List<Integer> numbers = new LinkedList<Integer>(
				tmpNumbs.stream().map(Integer::valueOf).collect(Collectors.toList()));

		System.out.println("Answer: " + data.matheExpression + "=" + result(numbers, operators));
	}

}