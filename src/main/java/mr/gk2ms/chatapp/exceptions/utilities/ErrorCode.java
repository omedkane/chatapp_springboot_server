package mr.gk2ms.chatapp.exceptions.utilities;

import java.util.Map;

import mr.gk2ms.chatapp.utilities.classes.QuickResponses;

public enum ErrorCode {
	GENERIC_ERROR("CHATAPP-GENERIC", "The system is unable to complete the request. Contact system support."),
	RESOURCE_NOT_FOUND("CHATAPP-0001", "Request resource was not found"),
	USERNAME_NOT_FOUND("CHATAPP-0002", "No user with this email"),
	INVALID_REQUEST("CHATAPP-0003", "This is not a valid request"),
	INVALID_REFRESH_TOKEN("CHATAPP-0004", "No user with this email"),
	INSUFFICIENT_AUTHENTICATION("CHATAPP-0005", "User is not authenticated");

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

	public Map<String, Object> makeResponse() {
		return QuickResponses.error(getCode(), getMessage());
	}

	public Map<String, Object> makeResponse(String message) {
		return QuickResponses.error(getCode(), message);
	}
}
