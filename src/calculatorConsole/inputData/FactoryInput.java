package calculatorConsole.inputData;

public class FactoryInput {

	public Input createInput(VersionInput verInput) {

		switch (verInput) {
		case ONE_LIMIT:
			return new OneLimit();
		case ONE_NO_LIMIT:
			return new OneNotLimit();
		case MULTI_LIMIT:
			return new MultiLimit();
		case MULTI_NO_LIMIT:
			return new MultiNoLimit();
		}
		return null;
	}
}
