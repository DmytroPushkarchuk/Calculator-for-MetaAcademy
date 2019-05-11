package calculatorConsole.calculators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import calculatorConsole.Data;
import calculatorConsole.Logic;

public class RomanCalculator extends Logic implements Calculator {

	public void calculation(Data data) {

		List<String> operators = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[MDCLXVI0-9]+")));

		List<String> tmpNumbs = new LinkedList<String>(Arrays.asList(data.matheExpression.split("[+*/-]")));

		List<Integer> numbers = new LinkedList<Integer>();

		for (int i = 0; i < tmpNumbs.size(); i++) {
			numbers.add(convertRomanToArabic(tmpNumbs.get(i)));
		}

		System.out.println(
				data.matheExpression + "=" + convertArabicToRoman(Integer.valueOf(result(numbers, operators))));
	}

	private Integer result(List<Integer> numbers, List<String> operators) {

		if (operators.size() == 1) {
			return numbers.get(0);
		}

//		������������ ��������� �������� �������� � ������
		for (int i = 1; i < operators.size(); i++) {
			if ((operators.get(i).equals("*")) || (operators.get(i).equals("/"))){
				switch (operators.get(i)) {
				case "*":
					numbers.set(i - 1, numbers.get(i - 1) * numbers.get(i));
					break;
				case "/":
					if (numbers.get(i) == 0) {
						System.out.println("������� ������ �� 0");
						return null;
					}
					numbers.set(i - 1, numbers.get(i - 1) / numbers.get(i));
					break;
				}

				numbers.remove(i);
				operators.remove(i);

//				������������
				return result(numbers, operators);
			}
		}

//		��������� �������� ��������� � ��������
		int in = numbers.get(0);

		for (int i = 1; i < operators.size(); i++) {
			switch (operators.get(i)) {
			case "+":
				in += +numbers.get(i);
				break;
			case "-":
				in -= numbers.get(i);
				break;
			}
		}

		return in;
	}

}
