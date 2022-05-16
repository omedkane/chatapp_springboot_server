package mr.gk2ms.chatapp.exceptions;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

public class InvalidRefreshTokenException extends BaseException {
	public InvalidRefreshTokenException(ErrorCode errorCode) {
		super(errorCode.getCode(), errorCode.getMessage());	}

	public InvalidRefreshTokenException(String message) {
		super(ErrorCode.INVALID_REFRESH_TOKEN.getCode(), message);
	}
}
