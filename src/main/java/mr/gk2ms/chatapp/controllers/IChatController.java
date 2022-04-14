package mr.gk2ms.chatapp.controllers;

import org.springframework.http.ResponseEntity;

import mr.gk2ms.chatapp_spring_server.model.Chat;

public interface IChatController {

	public ResponseEntity<Chat> read(String chatId);

	public ResponseEntity<Chat> create(String senderId, String receiverId);

	public ResponseEntity<Void> delete(String chatId);
}
