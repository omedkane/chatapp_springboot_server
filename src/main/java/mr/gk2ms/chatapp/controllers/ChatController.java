package mr.gk2ms.chatapp.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.services.ChatService;
import mr.gk2ms.chatapp.services.UserService;
import mr.gk2ms.chatapp.utilities.classes.PageResponse;
import mr.gk2ms.chatapp_spring_server.model.Chat;
import mr.gk2ms.chatapp_spring_server.model.SendMessageRequest;

@RestController
@RequestMapping("/chats")
public class ChatController {
	private UserService userService;
	private ChatService service;

	public ChatController(UserService userService, ChatService service) {
		this.userService = userService;
		this.service = service;
	}
	// This is for testing purposes !
	@GetMapping("/dororo")
	public String yoohoo() {
		return "Hello";
	}

	@PostMapping
	public
		ResponseEntity<Chat>
		createByMessage(@AuthenticationPrincipal Jwt principal, @RequestBody SendMessageRequest msg) {
		@Valid
		@Email(message = "Must be a valid email address !")
		String receiverEmail = msg.getTarget();
		String currentUserEmail = principal.getSubject();

		UserEntity user = userService.findUserByEmail(currentUserEmail);
		UserEntity receiver = userService.findUserByEmail(receiverEmail);

		Chat chat = service.sendMessageToUser(user, receiver, msg.getMessage());
		return ResponseEntity.ok(chat);
	}

	@DeleteMapping("/{chatId}")
	public ResponseEntity<Void> delete(@PathVariable String chatId) {
		service.deleteChatById(chatId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Chat> getChatById(String chatId) {
		return ResponseEntity.ok(service.toModel(service.getChatById(chatId)));
	}

	@GetMapping("/all/{page}/{limit}")
	public ResponseEntity<PageResponse<Chat>> getAllChatByUserId(
		@AuthenticationPrincipal Jwt principal,
		@PathVariable("page") int page,
		@PathVariable("limit") int limit
	) {
		System.out.println("What's up with that ?");
		UserEntity currentUser = userService.findUserByEmail(principal.getSubject());
		PageResponse<Chat> pageResponse = service.getAllChatByUserId(currentUser, page, limit);

		return ResponseEntity.ok(pageResponse);
	}

}
