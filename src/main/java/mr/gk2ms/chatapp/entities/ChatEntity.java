package mr.gk2ms.chatapp.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name = "chats",
	uniqueConstraints = @UniqueConstraint(columnNames = { "recipient_A", "recipient_B" })
)
public class ChatEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		updatable = false,
		nullable = false
	)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "recipient_A")
	private UserEntity recipientA;

	@ManyToOne
	@JoinColumn(name = "recipient_B")
	private UserEntity recipientB;

	@Column
	private Timestamp dateCreated;

	@OneToMany(
		mappedBy = "chat",
		cascade = CascadeType.REMOVE
	)
	private List<ChatMessageEntity> messages;

	public ChatEntity() {
	}

	public ChatEntity(
		UUID id,
		UserEntity recipientA,
		UserEntity recipientB,
		Timestamp dateCreated,
		List<ChatMessageEntity> messages
	) {
		this.id = id;
		this.recipientA = recipientA;
		this.recipientB = recipientB;
		this.dateCreated = dateCreated;
		this.messages = messages;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UserEntity getrecipientA() {
		return this.recipientA;
	}

	public void setrecipientA(UserEntity recipientA) {
		this.recipientA = recipientA;
	}

	public UserEntity getrecipientB() {
		return this.recipientB;
	}

	public void setrecipientB(UserEntity recipientB) {
		this.recipientB = recipientB;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<ChatMessageEntity> getMessages() {
		return this.messages;
	}

	public void setMessages(List<ChatMessageEntity> messages) {
		this.messages = messages;
	}

	public ChatEntity id(UUID id) {
		setId(id);
		return this;
	}

	public ChatEntity recipientA(UserEntity recipientA) {
		setrecipientA(recipientA);
		return this;
	}

	public ChatEntity recipientB(UserEntity recipientB) {
		setrecipientB(recipientB);
		return this;
	}

	public ChatEntity dateCreated(Timestamp dateCreated) {
		setDateCreated(dateCreated);
		return this;
	}

	public ChatEntity messages(List<ChatMessageEntity> messages) {
		setMessages(messages);
		return this;
	}

}
