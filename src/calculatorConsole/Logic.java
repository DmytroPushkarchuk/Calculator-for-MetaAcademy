package calculatorConsole;

import calculatorConsole.calculators.VersionCalculator;

public class Logic {

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

	public Boolean correctData(String data) {

		int tmpInt;

		if (data.matches("\\d+"))
			return true;

		if (data.matches("[MDCLXVI]+")) {
			tmpInt = convertRomanToArabic(data);
			if (data.equals(convertArabicToRoman(tmpInt)))
				return true;
		}

		return false;
	}

	public Boolean correctOperator(String data) {

		if (data.matches("[+-/]"))
			return true;

		return false;
	}

	public VersionCalculator typeCalculator(String first, String second, String operator) {

		if (correctData(first) && correctData(second) && correctOperator(operator)) {

			if ((first.matches("\\d+")) && (second.matches("\\d+")))
				return VersionCalculator.ARABIC;

			if ((first.matches("[MDCLXVI]+")) && (second.matches("[MDCLXVI]+")))
				return VersionCalculator.ROMANIC;

		}
		return null;
	}

}