package calculatorConsole.calculators;

public class FactoryCalculator {

	public Calculator createCalculator(VersionCalculator str) {

		switch (str) {
		case ARABIC:
			return new ArabicCalkulator();
		case ROMAN:
			return new RomanCalculator();
		}
		return null;
	}
}
