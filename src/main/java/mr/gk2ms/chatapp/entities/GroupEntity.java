package mr.gk2ms.chatapp.entities;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		updatable = false,
		nullable = false
	)
	private UUID id;

	@Column
	private String name;

	@ManyToMany(mappedBy = "groups")
	private Set<UserEntity> members;

	@OneToMany(
		mappedBy = "group",
		cascade = CascadeType.REMOVE,
		targetEntity = GroupMessageEntity.class
	)
	private Set<GroupMessageEntity> messages;

	@Column
	private Timestamp dateCreated;

	@OneToOne
	private UserEntity administrator;

	public GroupEntity() {
	}

	public GroupEntity(
		UUID id,
		String name,
		Set<UserEntity> members,
		Set<GroupMessageEntity> messages,
		Timestamp dateCreated,
		UserEntity administrator
	) {
		this.id = id;
		this.name = name;
		this.members = members;
		this.messages = messages;
		this.dateCreated = dateCreated;
		this.administrator = administrator;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserEntity> getMembers() {
		return this.members;
	}

	public void setMembers(Set<UserEntity> members) {
		this.members = members;
	}

	public Set<GroupMessageEntity> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<GroupMessageEntity> messages) {
		this.messages = messages;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public UserEntity getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(UserEntity administrator) {
		this.administrator = administrator;
	}

	public GroupEntity id(UUID id) {
		setId(id);
		return this;
	}

	public GroupEntity name(String name) {
		setName(name);
		return this;
	}

	public GroupEntity members(Set<UserEntity> members) {
		setMembers(members);
		return this;
	}

	public GroupEntity messages(Set<GroupMessageEntity> messages) {
		setMessages(messages);
		return this;
	}

	public GroupEntity dateCreated(Timestamp dateCreated) {
		setDateCreated(dateCreated);
		return this;
	}

	public GroupEntity administrator(UserEntity administrator) {
		setAdministrator(administrator);
		return this;
	}

}
