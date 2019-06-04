package jp.sou4j.microsoft.cognitive.luis;

public class LUISException extends Exception {

	private static final long serialVersionUID = 1L;

	public LUISException() {
		super();
	}

	public LUISException(String message) {
		super(message);
	}

	public LUISException(String message, Throwable cause) {
		super(message, cause);
	}

	public LUISException(Throwable cause) {
		super(cause);
	}
}
