package mr.gk2ms.chatapp.security.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
	USER("ROLES_USER"), ADMIN("ROLES_ADMIN");

	private String authority;

	Roles(String authority) {
		this.authority = authority;
	}

	@JsonValue
	@Override
	public String getAuthority() {
		return authority;
	}

	public static Roles fromAuthority(String authority) {
		for (Roles role : Roles.values()) {
			if (role.authority.equals(authority))
				return role;
		}

		throw new IllegalArgumentException("Unexpected Value");
	}

	@Override
	public String toString() {
		return String.valueOf(this.authority);
	}

}
