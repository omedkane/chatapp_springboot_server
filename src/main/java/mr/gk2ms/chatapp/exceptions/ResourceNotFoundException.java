package mr.gk2ms.chatapp.exceptions;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

public class ResourceNotFoundException extends BaseException {
	public ResourceNotFoundException(ErrorCode errorCode) {
		super(errorCode.getCode(), errorCode.getMessage());
	}

	public ResourceNotFoundException(String message) {
		super(ErrorCode.RESOURCE_NOT_FOUND.getCode(), message);
	}
}
