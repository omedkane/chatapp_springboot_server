package mr.gk2ms.chatapp.utilities.classes;

import java.util.HashMap;
import java.util.Map;

import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

interface BodySetter {
	public void set(Map<String, Object> body);
}

public class QuickResponses {
	public static Map<String, Object> body(BodySetter function) {
		HashMap<String, Object> body = new HashMap<String, Object>();
		function.set(body);
		return body;
	}

	public static Map<String, Object> message(String message) {
		return body(body -> {
			body.put("MESSAGE", message);
		});
	}

	public static Map<String, Object> message(String message, Object target) {
		return body(body -> {
			body.put("MESSAGE", message);
			body.put("TARGET", target);
		});
	}

	public static Map<String, Object> error(String errorCode, String message) {
		return body(body -> {
			body.put("ERROR_CODE", errorCode);
			body.put("MESSAGE", message);
		});
	}

	public static Map<String, Object> error(ErrorCode error) {
		return error(error.getCode(), error.getMessage());
	}

}
