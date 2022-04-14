package mr.gk2ms.chatapp.security.helpers;

import static java.util.stream.Collectors.toList;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static mr.gk2ms.chatapp.security.Constants.EXPIRATION_TIME;
import static mr.gk2ms.chatapp.security.Constants.ROLES_CLAIM;

@Component
public class JwtManager {
	public RSAPrivateKey privateKey;
	public RSAPublicKey publicKey;

	public JwtManager(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	public String create(UserDetails principal) {
		final long now = System.currentTimeMillis();

		return JWT
			.create()
			.withIssuer("GK2MS/ChatApp")
			.withSubject(principal.getUsername())
			.withIssuedAt(new Date(now))
			.withExpiresAt(new Date(now + EXPIRATION_TIME))
			.withClaim(
				ROLES_CLAIM,
				principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(toList())
			)
			.sign(Algorithm.RSA256(publicKey, privateKey));
	}
}
