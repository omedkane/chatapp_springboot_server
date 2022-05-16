package mr.gk2ms.chatapp.resolvers;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mr.gk2ms.chatapp.exceptions.ResourceNotFoundException;
import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;

@ControllerAdvice
public class ControllerExceptionResolver extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Object> handleException(HttpServletRequest request, Exception ex, Locale locale) {
		return ResponseEntity.internalServerError().body(ErrorCode.GENERIC_ERROR.makeResponse());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request
	) {
		HashMap<String, String> errors = new HashMap<String, String>();
		ex.getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InsufficientAuthenticationException.class)
	protected ResponseEntity<ErrorCode> handleInsufficientAuthenticationException(
		HttpServletRequest request,
		InsufficientAuthenticationException ex,
		Locale locale
	) {
		return new ResponseEntity<ErrorCode>(ErrorCode.INSUFFICIENT_AUTHENTICATION, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(value = UsernameNotFoundException.class)
	protected
		ResponseEntity<Object>
		handleUsernameNotFoundException(HttpServletRequest request, UsernameNotFoundException ex, Locale locale) {

		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(ErrorCode.USERNAME_NOT_FOUND.makeResponse(ex.getMessage()));
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	protected
		ResponseEntity<Object>
		handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex, Locale locale) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.makeResponse());
	}
}
