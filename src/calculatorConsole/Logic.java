package calculatorConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculatorConsole.calculators.VersionCalculator;

public class Logic {

/*	визначення типу калькулятора і перевіряє вираз на валідність,
    при помилці у виразі повертає null і друкує помилку */
	public VersionCalculator typeCalculator(String expression) {

// 		колекція чисел
		List<String> numbers = Arrays.asList(expression.split("[+*/-]"));
//		колекція операторів
		List<String> operators = Arrays.asList(expression.split("[MDCLXVI0-9]+"));
		
		List<VersionCalculator> types = new ArrayList<>();

		
//		перевірка кількості операторів
		if (operators.size() != numbers.size()) {
			System.out.println("problem with operators!");
			return null;
		}
		
//		перевірка операторів
		for (int i = 1; i < operators.size(); i++) {
			if (!correctOperator(operators.get(i))) {
				System.out.println("not a valid operator!");
				return null;
			}
		}

//		перевірка всіх чисел на коректність
		for (int i = 0; i < numbers.size(); i++) {
			if (!(correctNumber(numbers.get(i)))) {
				System.out.println("not a valid number!");
				return null;
			}
		}

// 		визначення типу кожного числа	
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i).matches("\\d+"))
				types.add(i, VersionCalculator.ARABIC);
			if (numbers.get(i).matches("[MDCLXVI]+"))
				types.add(i, VersionCalculator.ROMAN);
		}

//		перевіряє чи всі елементи одного типу
		for (int i = 1; i < types.size(); i++) {
			if (types.get(i-1) != types.get(i)) {
				System.out.println("all numbers must be of the same type!");
				return null;
			}
		}

		return types.get(0);
	}
	
//	перевірка на коректність числа
	public Boolean correctNumber(String number) {

		if (number.matches("\\d+")) {
			try {
				Integer.valueOf(number);
			} catch (Exception e) {
				System.out.println("goes beyond the range of an integer");
				return false;
			}
			return true;
		}
		
		int tmpInt = convertRomanToArabic(number);
		if (number.matches("[MDCLXVI]+")) {
			if (number.equals(convertArabicToRoman(tmpInt)))
				return true;
		}
		return false;
	}

//	перевірка на коректність оператора
	public Boolean correctOperator(String operator) {
		if (operator.matches("[+*/-]"))
			return true;
		return false;
	}

//	перетвонення арабських цифер в римські
	public String convertArabicToRoman(int input) {

		if (input < 1 || input > 3999)
			
			return "invalid roman number value";
		String s = "";

		while (input >= 1000) {
			s += "M";
			input -= 1000;
		}
		while (input >= 900) {
			s += "CM";
			input -= 900;
		}
		while (input >= 500) {
			s += "D";
			input -= 500;
		}
		while (input >= 400) {
			s += "CD";
			input -= 400;
		}
		while (input >= 100) {
			s += "C";
			input -= 100;
		}
		while (input >= 90) {
			s += "XC";
			input -= 90;
		}
		while (input >= 50) {
			s += "L";
			input -= 50;
		}
		while (input >= 40) {
			s += "XL";
			input -= 40;
		}
		while (input >= 10) {
			s += "X";
			input -= 10;
		}
		while (input >= 9) {
			s += "IX";
			input -= 9;
		}
		while (input >= 5) {
			s += "V";
			input -= 5;
		}
		while (input >= 4) {
			s += "IV";
			input -= 4;
		}
		while (input >= 1) {
			s += "I";
			input -= 1;
		}
		return s;
	}

//  перетворення римських цифер в арабські
	public int convertRomanToArabic(String roman) {
		int result = 0;
		String uRoman = roman.toUpperCase();
		for (int i = 0; i < uRoman.length() - 1; i++) {
			if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
				result -= decodeSingle(uRoman.charAt(i));
			} else {
				result += decodeSingle(uRoman.charAt(i));
			}
		}
		result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
		return result;
	}

	private static int decodeSingle(char letter) {
		switch (letter) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		default:
			return 0;
		}
	}

}