package mr.gk2ms.chatapp.exceptions;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

public class InvalidRequestException extends BaseException {
	public InvalidRequestException(ErrorCode errorCode) {
		super(errorCode.getCode(), errorCode.getMessage());
	}

	public InvalidRequestException(String message) {
		super(ErrorCode.INVALID_REQUEST.getCode(), message);
	}
}
