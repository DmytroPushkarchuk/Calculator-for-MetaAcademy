package calculatorConsole;

import calculatorConsole.calculators.VersionCalculator;

public class Logic {

//	���������� ���� ������������, ����������� ����� = null
	public VersionCalculator typeCalculator(String data) {
		
// 		����� �����
		String[] numbers = data.split("[+*/-]");
//		����� ���������
		String[] operators = data.split("[MDCLXVI0-9]+");
		VersionCalculator[] type = new VersionCalculator[numbers.length];

//		�������� ���������
		for (int i = 1; i < operators.length; i++) {
			if (!correctOperaror(operators[i])) {
				System.out.println("����������� �������� �" + i);
				return null;
			}
		}

//		�������� ��� ����� �� ����������
		for (int i = 0; i < numbers.length; i++) {
			if (!(correctNumber(numbers[i]))) {
				System.out.println("���������� ����� �" + ++i);
				return null;
			}
		}

// 		������� ��� ������� �����		
		for (int i = 0; i < type.length; i++) {
			if (numbers[i].matches("\\d+"))
				type[i] = VersionCalculator.ARABIC;
			if (numbers[i].matches("[MDCLXVI]+"))
				type[i] = VersionCalculator.ROMAN;
		}

//		�������� �� �� �������� ������ ����� ����
		for (int i = 1; i < type.length; i++) {
			if (type[i - 1] != type[i]) {
				System.out.println("�� ����� ������ ���� ������ ����");
				return null;
			}
		}

		return type[0];
	}

//	�������� �� ���������� �����
	public Boolean correctNumber(String data) {
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

//	�������� �� ���������� ���������
	public Boolean correctOperaror(String data) {
		if (data.matches("[+*/-]")) 
			return true;
		return false;
	}

//	������������ �������� ����� � �������
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

//	������������ ��������� ����� � ������
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