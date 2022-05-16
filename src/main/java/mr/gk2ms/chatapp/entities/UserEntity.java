package mr.gk2ms.chatapp.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		updatable = false,
		nullable = false
	)
	private UUID id;

	@Column
	@NotEmpty(message = "Fist name is mandatory")
	private String firstName;

	@Column
	@NotEmpty(message = "Last name is mandatory")
	private String lastName;

	@Column
	@Email
	@NotEmpty(message = "Email is mandatory")
	private String email;

	@Column
	private String avatarURI;

	@Column
	private String password;

	@ManyToMany(mappedBy = "members")
	private Set<GroupEntity> groups;

	@OneToMany(mappedBy = "recipientA")
	private Set<ChatEntity> chats;

	public UserEntity() {
	}

	public UserEntity(
		UUID id,
		String firstName,
		String lastName,
		String email,
		String avatarURI,
		String password,
		Set<GroupEntity> groups
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.avatarURI = avatarURI;
		this.password = password;
		this.groups = groups;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatarURI() {
		return this.avatarURI;
	}

	public void setAvatarURI(String avatarURI) {
		this.avatarURI = avatarURI;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<GroupEntity> getGroups() {
		return this.groups;
	}

	public void setGroups(Set<GroupEntity> groups) {
		this.groups = groups;
	}

	public UserEntity id(UUID id) {
		setId(id);
		return this;
	}

	public UserEntity firstName(String firstName) {
		setFirstName(firstName);
		return this;
	}

	public UserEntity lastName(String lastName) {
		setLastName(lastName);
		return this;
	}

	public UserEntity email(String email) {
		setEmail(email);
		return this;
	}

	public UserEntity avatarURI(String avatarURI) {
		setAvatarURI(avatarURI);
		return this;
	}

	public UserEntity password(String password) {
		setPassword(password);
		return this;
	}

	public UserEntity groups(Set<GroupEntity> groups) {
		setGroups(groups);
		return this;
	}

}
