package mr.gk2ms.chatapp.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mr.gk2ms.chatapp.entities.ChatEntity;
import mr.gk2ms.chatapp.entities.ChatMessageEntity;
import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.exceptions.ResourceNotFoundException;
import mr.gk2ms.chatapp.repositories.ChatMessageRepository;
import mr.gk2ms.chatapp.repositories.ChatRepository;
import mr.gk2ms.chatapp.utilities.classes.PageResponse;
import mr.gk2ms.chatapp_spring_server.model.Chat;
import mr.gk2ms.chatapp_spring_server.model.User;

@Service
public class ChatService extends BaseService<ChatEntity, Chat> {
	private ChatRepository repository;
	private ChatMessageRepository messageRepository;
	private UserService userService;

	public ChatService(ChatRepository repository, ChatMessageRepository messageRepository, UserService userService) {
		this.repository = repository;
		this.messageRepository = messageRepository;
		this.userService = userService;
	}

	public Chat sendMessageToUser(UserEntity currentUser, UserEntity receiver, String messageText) {
		ChatEntity chatEntity = repository
			.getChatByRecipients(currentUser.getId(), receiver.getId())
			.orElse(
				repository
					.save(
						new ChatEntity()
							.recipientA(currentUser)
							.recipientB(receiver)
							.dateCreated(Timestamp.from(Instant.now()))
					)
			);

		ChatMessageEntity message = new ChatMessageEntity();

		message.chat(chatEntity).sender(currentUser).text(messageText).dateSent(Timestamp.from(Instant.now()));
		messageRepository.save(message);

		return toModel(chatEntity);
	}

	public void deleteChatById(String chatId) {
		repository.delete(getChatById(chatId));
	}

	public ChatEntity getChatById(String chatId) {
		ChatEntity chat = repository.getById(UUID.fromString(chatId));
		if (Objects.nonNull(chat)) {
			return chat;
		} else {
			throw new ResourceNotFoundException("Chat doesn't exist");
		}
	}

	public PageResponse<Chat> getAllChatByUserId(UserEntity user, int page, int size) {
		Pageable pageRequest = PageRequest.of(page, size);

		Page<ChatEntity> results = repository.getAllChatsByUserId(user.getId(), pageRequest);

		return new PageResponse<Chat>()
			.totalItems(results.getNumber())
			.totalPages(results.getTotalPages())
			.items(toModelList(results.getContent()));
	}

	@Override
	public Chat toModel(ChatEntity chatEntity) {
		User recipientA = userService.toModel(chatEntity.getrecipientA());
		User recipientB = userService.toModel(chatEntity.getrecipientB());

		return new Chat()
			.id(chatEntity.getId().toString())
			.recipientA(recipientA)
			.recipientB(recipientB)
			.dateCreated((int) chatEntity.getDateCreated().getTime());
	}

}
