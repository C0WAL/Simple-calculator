package validation;

@SuppressWarnings("serial")
public class FieldValidationException extends Exception {

	public FieldValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldValidationException(String message) {
		super(message);
	}
}
