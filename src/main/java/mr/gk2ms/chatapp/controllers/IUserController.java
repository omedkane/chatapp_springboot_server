package mr.gk2ms.chatapp.controllers;

import org.springframework.http.ResponseEntity;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp_spring_server.model.User;

public interface IUserController {
	
	public ResponseEntity<User> create(UserEntity user);
	
	public ResponseEntity<User> delete(String userId);
	
	public ResponseEntity<User> update(UserEntity user);
	
	public ResponseEntity<User> read(String userId);
}
