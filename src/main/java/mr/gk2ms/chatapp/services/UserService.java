package mr.gk2ms.chatapp.services;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.exceptions.GenericAlreadyExistsException;
import mr.gk2ms.chatapp.repositories.UserRepository;
import mr.gk2ms.chatapp_spring_server.model.User;

@Service
public class UserService extends BaseService<UserEntity, User> {
	private UserRepository repository;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserEntity getCurrentUser() {
		Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String currentUserEmail = principal.getSubject();

		return findUserByEmail(currentUserEmail);
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

	public List<UserEntity> findAllUsersByEmail(List<String> emails) {
		return repository.findAllByEmail(emails);
	}

	public UserEntity createUser(User user) {
		String email = user.getEmail();
		if (repository.findByEmail(email).isPresent()) {
			throw new GenericAlreadyExistsException(
				String.format("A User associated with this email (%s) already exists", email)
			);
		} else {
			return repository.save(toEntity(user));
		}
	}

	@Override
	public UserEntity toEntity(User user) {
		UserEntity userEntity = new UserEntity();

		String encodedPassword = passwordEncoder.encode(user.getPassword());

		BeanUtils.copyProperties(user, userEntity);

		userEntity.password(encodedPassword);

		return userEntity;
	}

	@Override
	public User toModel(UserEntity userEntity) {
		User user = new User()
			.firstName(userEntity.getFirstName())
			.lastName(userEntity.getLastName())
			.email(userEntity.getEmail())
			.avatarURI(userEntity.getAvatarURI());

		return user;
	}
}
