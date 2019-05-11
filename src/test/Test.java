package test;

import calculatorConsole.Logic;

public class Test {

	public static void main(String[] args) {

		Logic logic = new Logic();
		System.out.println(logic.convertRomanToArabic("C"));
		System.out.println(logic.convertArabicToRoman(100));

		String s = "No";
		Str(s);
		System.out.println(s);

	}

	static void Str(String str) {
		str = "Yes";
	}

}
