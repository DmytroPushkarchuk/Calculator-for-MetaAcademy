package calculatorDesktop;

public class Logic {

//---------------------------------------------------------------------------------------------- calculation

	public static Double outputEquals(Double firstNum, Double secondNum, String operator) {

		if (firstNum != null && operator != null && secondNum != null) {

			switch (operator) {
			case "+":
				return firstNum + secondNum;
			case "-":
				return firstNum - secondNum;
			case "*":
				return firstNum * secondNum;
			case "/":
				return firstNum / secondNum;
			}
		}
		return null;
	}

//------------------------------------------------------ convert DoubleToText, TextToDouble and fix problems

	public static String convertDoubleToText(Double value) {
		String tmpText = String.valueOf(value);

		while ((tmpText.contains("."))
				&& (tmpText.charAt(tmpText.length() - 1) == '0' || tmpText.charAt(tmpText.length() - 1) == '.')) {
			tmpText = tmpText.substring(0, tmpText.length() - 1);
		}
		return tmpText;
	}

	public static Double convertTextToDouble(String str) {
		if (str.charAt(0) == '-' && Double.valueOf(str.substring(1)) == 0) {
			return (double) 0;
		}
		if (str == "Infinity" || str == "null") {
			return (double) 0;
//			return null;
		} else {
			return Double.valueOf(str);
		}
	}

}
