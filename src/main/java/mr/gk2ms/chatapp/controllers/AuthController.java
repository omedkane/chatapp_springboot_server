package mr.gk2ms.chatapp.controllers;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.exceptions.ResourceNotFoundException;
import mr.gk2ms.chatapp.exceptions.utilities.ErrorCode;
import mr.gk2ms.chatapp.services.AuthService;
import mr.gk2ms.chatapp.services.UserService;
import mr.gk2ms.chatapp_spring_server.api.AuthApi;
import mr.gk2ms.chatapp_spring_server.model.RefreshToken;
import mr.gk2ms.chatapp_spring_server.model.SignInRequest;
import mr.gk2ms.chatapp_spring_server.model.SignedInUser;
import mr.gk2ms.chatapp_spring_server.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthApi {
	private final AuthService service;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public AuthController(AuthService authService, UserService userService, PasswordEncoder passwordEncoder) {
		this.service = authService;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/signin")
	public ResponseEntity<SignedInUser> signIn(@Valid SignInRequest signInRequest) {
		String email = signInRequest.getEmail();
		String password = signInRequest.getPassword();

		UserEntity user = userService.findUserByEmail(email);

		if (Objects.isNull(user)) {
			throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND);
		}

		boolean passMatches = passwordEncoder.matches(password, user.getPassword());

		if (passMatches) {
			return ResponseEntity.ok(service.getSignedInUser(user));
		} else {
			throw new InsufficientAuthenticationException("Email or password may be incorrect");
		}
	}

	@PostMapping("/signout")
	public ResponseEntity<Void> signOut(@Valid RefreshToken refreshToken) {
		service.removeRefreshToken(refreshToken);

		return ResponseEntity.accepted().build();
	}

	@PostMapping("/signup")
	public ResponseEntity<SignedInUser> signUp(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.signUserUp(user).get());
	}

	public ResponseEntity<SignedInUser> getAccessToken(@Valid RefreshToken refreshToken) {
		return ResponseEntity.ok(service.getAccessToken(refreshToken).get());
	}
}
