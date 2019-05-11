package calculatorConsole.inputData;


public class FactoryInput {

	public  Input createInput(VersionInput verInput) {
	
		switch (verInput) {
		case LITE:
			return new LiteInput();
		case MEDIUM:
			return new MediumInput();
		case NEW:
			return new NewInput();
		}
		
		return null;
	}
}
