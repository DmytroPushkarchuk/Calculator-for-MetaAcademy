package calculatorConsole.calculators;

import java.util.List;


public abstract class AbstractCalculator implements Calculator {

//	проводить розрахунки, при помилці ділення на 0 повертає null і друкує помилку
	protected Integer result(List<Integer> numbers, List<String> operators) {

		if (operators.size() == 1) {
			return numbers.get(0);
		}

//		першочергове виконання операцій множення і ділиння
		for (int i = 1; i < operators.size(); i++) {
			if ((operators.get(i).equals("*")) || (operators.get(i).equals("/"))) {
				
				switch (operators.get(i)) {
				case "*":
					numbers.set(i - 1, numbers.get(i - 1) * numbers.get(i));
					break;
				case "/":
					if (numbers.get(i) == 0) {
						System.out.println("division error by 0!");
						return null;
					}
					numbers.set(i - 1, numbers.get(i - 1) / numbers.get(i));
					break;
				}

				numbers.remove(i);
				operators.remove(i);

//				інкапсуляція
				return result(numbers, operators);
			}
		}

//		виконання операцій додавання і відіймання
		int value = numbers.get(0);

		for (int i = 1; i < operators.size(); i++) {
			switch (operators.get(i)) {
			case "+":
				value += +numbers.get(i);
				break;
			case "-":
				value -= numbers.get(i);
				break;
			}
		}

		return value;
	}
}
