package mr.gk2ms.chatapp.services;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.entities.UserTokenEntity;
import mr.gk2ms.chatapp.exceptions.GenericAlreadyExistsException;
import mr.gk2ms.chatapp.exceptions.InvalidRefreshTokenException;
import mr.gk2ms.chatapp.miscellaneous.utilities.RandomHolder;
import mr.gk2ms.chatapp.repositories.UserRepository;
import mr.gk2ms.chatapp.repositories.UserTokenRepository;
import mr.gk2ms.chatapp.security.config.constants.Roles;
import mr.gk2ms.chatapp.security.helpers.JwtManager;
import mr.gk2ms.chatapp_spring_server.model.RefreshToken;
import mr.gk2ms.chatapp_spring_server.model.SignedInUser;
import mr.gk2ms.chatapp_spring_server.model.User;

@Service
public class UserService {
	private UserRepository repository;
	private UserTokenRepository userTokenRepository;
	private JwtManager tokenManager;
	private PasswordEncoder passwordEncoder;

	public UserService(
		UserRepository repository,
		UserTokenRepository userTokenRepository,
		JwtManager tokenManager,
		PasswordEncoder passwordEncoder
	) {
		this.repository = repository;
		this.userTokenRepository = userTokenRepository;
		this.tokenManager = tokenManager;
		this.passwordEncoder = passwordEncoder;
	}

	public UserEntity findUserByEmail(@Valid @Email @NotEmpty String email) {
		return repository
			.findByEmail(email)
			.orElseThrow(
				() -> new UsernameNotFoundException(
					String.format("This email (%s) isn't associated with any account ", email)
				)
			);
	}

	public Optional<SignedInUser> createUser(User user) {
		String email = user.getEmail();
		if (repository.findByEmail(email).isPresent()) {
			throw new GenericAlreadyExistsException(
				String.format("A User associated with this email (%s) already exists", email)
			);
		} else {
			UserEntity userEntity = repository.save(toEntity(user));
			return Optional.of(createSignedUserWithRefreshToken(userEntity));
		}
	}

	private SignedInUser createSignedUserWithRefreshToken(UserEntity userEntity) {
		return createSignedInUser(userEntity).refreshToken(createRefreshToken(userEntity));
	}

	private SignedInUser createSignedInUser(UserEntity userEntity) {
		String accessToken = tokenManager
			.create(
				org.springframework.security.core.userdetails.User
					.builder()
					.username(userEntity.getEmail())
					.password(userEntity.getPassword())
					.authorities(Roles.USER)
					.build()
			);
		return new SignedInUser()
			.username(userEntity.getEmail())
			.accessToken(accessToken)
			.userId(userEntity.getId().toString());
	}

	private String createRefreshToken(UserEntity userEntity) {
		String token = RandomHolder.randomKey(128);

		userTokenRepository.save(new UserTokenEntity().refreshToken(token).user(userEntity));

		return token;
	}

	public SignedInUser getSignedInUser(UserEntity userEntity) {
		userTokenRepository.deleteByUserId(userEntity.getId());

		return createSignedUserWithRefreshToken(userEntity);
	}

	public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
		return userTokenRepository
			.findByRefreshToken(refreshToken.getRefreshToken())
			.map(userToken -> Optional.of(createSignedInUser(userToken.getUser())))
			.orElseThrow(() -> new InvalidRefreshTokenException("Invalid Token"));
	}

	public void removeRefreshToken(RefreshToken refreshToken) {
		userTokenRepository
			.findByRefreshToken(refreshToken.getRefreshToken())
			.ifPresentOrElse(userTokenRepository::delete, () -> {
				throw new InvalidRefreshTokenException("Invalid Refresh Token");
			});
	}

	public UserEntity toEntity(User user) {
		UserEntity userEntity = new UserEntity();

		String encodedPassword = passwordEncoder.encode(user.getPassword());

		BeanUtils.copyProperties(user, userEntity);

		userEntity.password(encodedPassword);

		return userEntity;
	}
}
