package mr.gk2ms.chatapp.exceptions.utilities;

public enum ErrorCode {
	RESOURCE_NOT_FOUND("CHATAPP-0001", "Request resource was not found");

	private final String code;
	private final String message;

	private ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
