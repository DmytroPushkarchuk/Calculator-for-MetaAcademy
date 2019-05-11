package calculatorConsole.calculators;

public class FactoryCalculator  {

	public Calculator createCalculator(VersionCalculator str) {
		Calculator tmpCAlculator = null;

		switch (str) {
		case ARABIC:
			tmpCAlculator = new ArabicCalkulator();
			break;
		case ROMAN:
			tmpCAlculator = new RomanCalculator();
			break;
		}
		return tmpCAlculator;
	}
}
