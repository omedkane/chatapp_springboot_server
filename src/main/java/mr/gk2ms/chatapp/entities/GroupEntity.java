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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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

	@ManyToOne
	@JoinColumn
	private UserEntity creator;

	@ManyToMany
	@JoinTable(
		name = "memberships",
		joinColumns = @JoinColumn(name = "group_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<UserEntity> members;

	@OneToMany(
		mappedBy = "group",
		cascade = CascadeType.REMOVE,
		targetEntity = GroupMessageEntity.class
	)
	private Set<GroupMessageEntity> messages;

	@Column
	private Timestamp dateCreated;

	@ManyToMany
	@JoinTable(name = "group_admins")
	private Set<UserEntity> administrators;

	public GroupEntity() {
	}

	public GroupEntity(
		UUID id,
		String name,
		UserEntity creator,
		Set<UserEntity> members,
		Set<GroupMessageEntity> messages,
		Timestamp dateCreated,
		Set<UserEntity> administrators
	) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.members = members;
		this.messages = messages;
		this.dateCreated = dateCreated;
		this.administrators = administrators;
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

	public UserEntity getCreator() {
		return this.creator;
	}

	public void setCreator(UserEntity creator) {
		this.creator = creator;
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

	public Set<UserEntity> getAdministrators() {
		return this.administrators;
	}

	public void setAdministrators(Set<UserEntity> administrators) {
		this.administrators = administrators;
	}

	public GroupEntity id(UUID id) {
		setId(id);
		return this;
	}

	public GroupEntity name(String name) {
		setName(name);
		return this;
	}

	public GroupEntity creator(UserEntity creator) {
		setCreator(creator);
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

	public GroupEntity administrators(Set<UserEntity> administrators) {
		setAdministrators(administrators);
		return this;
	}

}
