package mr.gk2ms.chatapp.security;

public abstract class Constants {
	public static final String SECRET_KEY = "7624e9d0-8ad1-5aef-a5f0-2437a54f823e";
	public static final String AUTHORITY_PREFIX = "ROLE_";
	public static final String ROLES_CLAIM = "roles";
	public static final int EXPIRATION_TIME = 86_400_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String SIGN_UP_URL = "/auth/signup";
	public static final String SIGN_IN_URL = "/auth/signin";
	public static final String TOKEN_URL = "/auth/token";
	public static final String REFRESH_URL = "/auth/token/refresh";
}
