package mr.gk2ms.chatapp.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.repositories.UserRepository;
import mr.gk2ms.chatapp_spring_server.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String sayHello() {
		return "Hello World";
	}

	@PostMapping
	public ResponseEntity<UserEntity> testingThingsOut(@Valid @RequestBody UserEntity reqUser) {
		return ResponseEntity.ok(reqUser);
	}

	public ResponseEntity<User> create(@RequestBody UserEntity reqUser) {
		UserEntity newUser = new UserEntity();

		repository.save(newUser);

		return ResponseEntity.ok(new User());
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<User> delete(@PathVariable String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> update(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/")
	public ResponseEntity<User> read(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
