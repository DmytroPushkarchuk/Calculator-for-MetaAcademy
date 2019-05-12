package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculatorConsole.Logic;

public class Test extends Logic {

	public static void main(String[] args) {

//		Logic logic = new Logic();

//		System.out.println("MCCLXI = " + logic.convertRomanToArabic("MCCLXI"));
//		System.out.println("1261 = " + logic.convertArabicToRoman(1261));

		Integer i = indexOfReg("[*/]", "2+3+8+*4/");
		System.out.println(i);

		Integer j = lastIndexOfReg("[+-]", "2+3+8+*4/");
		System.out.println(j);

		System.out.println("2+3+8+*4/".substring(2, 6));
	}

	protected static Integer indexOfReg(String reg, String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())
			return matcher.start();
		return -1;
	}

	public static int lastIndexOfReg(String reg, String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		int lastIndex = -1;
		while (matcher.find())
			lastIndex = matcher.start();
		return lastIndex;
	}

}
