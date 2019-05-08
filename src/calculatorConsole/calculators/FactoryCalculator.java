package calculatorConsole.calculators;

public class FactoryCalculator  {

	public Calculator createCalculator(VarietyCalculator str) {
		Calculator tmpCAlculator = null;

		switch (str) {
		case ARABIC:
			tmpCAlculator = new ArabicCalkulator();
			break;
		case ROMANIC:
			tmpCAlculator = new RomanCalculator();
			break;
		}
		return tmpCAlculator;
	}
}
