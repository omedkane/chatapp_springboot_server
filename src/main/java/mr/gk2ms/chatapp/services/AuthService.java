package mr.gk2ms.chatapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.entities.UserTokenEntity;
import mr.gk2ms.chatapp.exceptions.InvalidRefreshTokenException;
import mr.gk2ms.chatapp.miscellaneous.utilities.RandomHolder;
import mr.gk2ms.chatapp.repositories.UserTokenRepository;
import mr.gk2ms.chatapp.security.config.constants.Roles;
import mr.gk2ms.chatapp.security.helpers.JwtManager;
import mr.gk2ms.chatapp_spring_server.model.RefreshToken;
import mr.gk2ms.chatapp_spring_server.model.SignedInUser;
import mr.gk2ms.chatapp_spring_server.model.User;

@Service
public class AuthService {
	private UserTokenRepository userTokenRepository;
	private JwtManager tokenManager;
	private UserService userService;

	public AuthService(UserTokenRepository userTokenRepository, JwtManager tokenManager, UserService userService) {
		this.userTokenRepository = userTokenRepository;
		this.tokenManager = tokenManager;
		this.userService = userService;
	}

	public Optional<SignedInUser> signUserUp(User user) {
		UserEntity userEntity = userService.createUser(user);
		return Optional.of(createSignedUserWithRefreshToken(userEntity));
	}

	public SignedInUser createSignedUserWithRefreshToken(UserEntity userEntity) {
		return createSignedInUser(userEntity).refreshToken(createRefreshToken(userEntity));
	}

	public SignedInUser createSignedInUser(UserEntity userEntity) {
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

	public String createRefreshToken(UserEntity userEntity) {
		String token = RandomHolder.randomKey(128);

		userTokenRepository.save(new UserTokenEntity().refreshToken(token).user(userEntity));

		return token;
	}

	@Transactional
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

	public Optional<UserEntity> getUserByRefreshToken(String refreshToken) {
		return Optional.of(userTokenRepository.findByRefreshToken(refreshToken).get().getUser());
	}

	public void removeRefreshToken(RefreshToken refreshToken) {
		userTokenRepository
			.findByRefreshToken(refreshToken.getRefreshToken())
			.ifPresentOrElse(userTokenRepository::delete, () -> {
				throw new InvalidRefreshTokenException("Invalid Refresh Token");
			});
	}
}
