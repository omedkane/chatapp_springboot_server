package mr.gk2ms.chatapp.services;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	public UserEntity findUserByEmail(@Valid @Email @NotEmpty String email) {
		return repository
			.findByEmail(email)
			.orElseThrow(
				() -> new UsernameNotFoundException(
					String.format("This email (%s) isn't associated with any account ", email)
				)
			);
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
