package mr.gk2ms.chatapp.exceptions;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

public class GenericAlreadyExistsException extends BaseException {
	public GenericAlreadyExistsException(ErrorCode errorCode) {
		super(errorCode.getCode(), errorCode.getMessage());
	}

	public GenericAlreadyExistsException(String message) {
		super(ErrorCode.GENERIC_ERROR.getCode(), message);
	}

}
