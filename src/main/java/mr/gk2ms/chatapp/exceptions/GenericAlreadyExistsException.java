package mr.gk2ms.chatapp.exceptions;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

public class GenericAlreadyExistsException extends RuntimeException {
	public final String message;
	private final String code;

	public GenericAlreadyExistsException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.message = errorCode.getMessage();
		this.code = errorCode.getCode();
	}

	public GenericAlreadyExistsException(String message) {
		super(message);
		this.message = message;
		this.code = ErrorCode.RESOURCE_NOT_FOUND.getCode();
	}

	public String getMessage() {
		return this.message;
	}

	public String getCode() {
		return this.code;
	}

}