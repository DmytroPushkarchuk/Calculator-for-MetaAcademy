package calculatorConsole.inputData;


public class FactoryInput {

	public  Input createInput(VersionInput verInput) {
	
		switch (verInput) {
		case LITE:
			return new LiteInput();
		case FULL:
			return new FullInput();
		}
		
		return null;
	}
}
