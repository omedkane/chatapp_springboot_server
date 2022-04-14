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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_messages")
public class GroupMessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		updatable = false,
		nullable = false
	)
	private UUID id;

	@OneToOne
	@JoinColumn
	private UserEntity sender;

	@ManyToOne
	@JoinColumn(
		name = "group_id",
		nullable = false
	)
	private GroupEntity group;

	@Column
	private Timestamp dateSent;

	@Column
	private String text;

	public GroupMessageEntity() {
	}

	public GroupMessageEntity(UUID id, UserEntity sender, GroupEntity group, Timestamp dateSent, String text) {
		this.id = id;
		this.sender = sender;
		this.group = group;
		this.dateSent = dateSent;
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

	public GroupEntity getGroup() {
		return this.group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	public Timestamp getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public GroupMessageEntity id(UUID id) {
		setId(id);
		return this;
	}

	public GroupMessageEntity sender(UserEntity sender) {
		setSender(sender);
		return this;
	}

	public GroupMessageEntity group(GroupEntity group) {
		setGroup(group);
		return this;
	}

	public GroupMessageEntity dateSent(Timestamp dateSent) {
		setDateSent(dateSent);
		return this;
	}

	public GroupMessageEntity text(String text) {
		setText(text);
		return this;
	}

}
