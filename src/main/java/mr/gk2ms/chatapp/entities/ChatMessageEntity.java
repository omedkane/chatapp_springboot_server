package mr.gk2ms.chatapp.entities;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chat_messages")
public class ChatMessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		updatable = false,
		nullable = false
	)
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private UserEntity sender;

	@Column
	private Timestamp dateSent;

	@ManyToOne
	private ChatEntity chat;

	@Column
	private String text;

	public ChatMessageEntity() {
	}

	public ChatMessageEntity(UUID id, UserEntity sender, Timestamp dateSent, ChatEntity chat, String text) {
		this.id = id;
		this.sender = sender;
		this.dateSent = dateSent;
		this.chat = chat;
		this.text = text;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UserEntity getSender() {
		return this.sender;
	}

	public void setSender(UserEntity sender) {
		this.sender = sender;
	}

	public Timestamp getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	public ChatEntity getChat() {
		return this.chat;
	}

	public void setChat(ChatEntity chat) {
		this.chat = chat;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ChatMessageEntity id(UUID id) {
		setId(id);
		return this;
	}

	public ChatMessageEntity sender(UserEntity sender) {
		setSender(sender);
		return this;
	}

	public ChatMessageEntity dateSent(Timestamp dateSent) {
		setDateSent(dateSent);
		return this;
	}

	public ChatMessageEntity chat(ChatEntity chat) {
		setChat(chat);
		return this;
	}

	public ChatMessageEntity text(String text) {
		setText(text);
		return this;
	}

}
