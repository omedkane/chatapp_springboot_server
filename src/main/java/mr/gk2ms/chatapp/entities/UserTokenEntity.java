package mr.gk2ms.chatapp.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_tokens")
public class UserTokenEntity {
	@Id
	@GeneratedValue
	@Column(
		name = "id",
		updatable = false,
		nullable = false
	)
	private UUID id;

	@NotNull(message = "Refresh token can't be null")
	@Column(
		name = "refresh_token",
		nullable = false
	)
	private String refreshToken;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_id")
	private UserEntity user;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public UserTokenEntity id(UUID id) {
		setId(id);
		return this;
	}

	public UserTokenEntity refreshToken(String refreshToken) {
		setRefreshToken(refreshToken);
		return this;
	}

	public UserTokenEntity user(UserEntity user) {
		setUser(user);
		return this;
	}

}
