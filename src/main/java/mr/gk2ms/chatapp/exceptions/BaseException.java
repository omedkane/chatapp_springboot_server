package mr.gk2ms.chatapp.exceptions;

import java.util.Map;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;
import mr.gk2ms.chatapp.utilities.classes.QuickResponses;

public class BaseException extends RuntimeException {
	private final String message;
	private final String code;

	public BaseException(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}

	public BaseException(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public Map<String, Object> makeResponse() {
		return QuickResponses.error(code, message);
	}

	public String getMessage() {
		return this.message;
	}

	public String getCode() {
		return this.code;
	}

}
