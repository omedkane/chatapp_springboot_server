package mr.gk2ms.chatapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.gk2ms.chatapp_spring_server.model.Chat;

@RestController
@RequestMapping("/chats")
public class ChatController implements IChatController {
	
	@PostMapping("/dororo")
	public String yoohoo() {
		return "Hello";
	}

	@GetMapping("/{chatId}")
	@Override
	public ResponseEntity<Chat> read(@PathVariable String chatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/{sender}/{receiver}")
	@Override
	public ResponseEntity<Chat> create(@PathVariable String senderId, @PathVariable String receiverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/{chatId}")
	@Override
	public ResponseEntity<Void> delete(@PathVariable String chatId) {
		// TODO Auto-generated method stub
		return null;
	}

}
