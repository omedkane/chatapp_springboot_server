package mr.gk2ms.chatapp.security.config.classes;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import mr.gk2ms.chatapp.security.config.constants.Roles;

import static mr.gk2ms.chatapp.security.Constants.SIGN_IN_URL;
import static mr.gk2ms.chatapp.security.Constants.SIGN_UP_URL;
import static mr.gk2ms.chatapp.security.Constants.TOKEN_URL;
import static mr.gk2ms.chatapp.security.Constants.REFRESH_URL;
import static mr.gk2ms.chatapp.security.Constants.AUTHORITY_PREFIX;
import static mr.gk2ms.chatapp.security.Constants.ROLES_CLAIM;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Value("${app.security.jwt.keystore-location}")
	private String keyStorePath;

	@Value("${app.security.jwt.keystore-password}")
	private String keyStorePassword;

	@Value("${app.security.jwt.keystore-alias}")
	private String keyAlias;

	@Value("${app.security.jwt.private-key-passphrase}")
	private String privateKeyPassphrase;

	// private UserDetailsService userDetailsService;

	// public SecurityConfig(UserDetailsService userDetailsService) {
	// this.userDetailsService = userDetailsService;
	// }

	@Bean
	public KeyStore keyStore() {
		try {
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

			InputStream keyfile = Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStorePath);

			keyStore.load(keyfile, keyStorePassword.toCharArray());
			return keyStore;
		} catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException exception) {
			LOG.error("Unable to load keystore: {}", keyStorePath, exception);
		}
		throw new IllegalArgumentException("Unable to load keystore");
	}

	@Bean
	public RSAPrivateKey jwtSigningKey(KeyStore keyStore) {
		try {
			Key privateKey = keyStore.getKey(keyAlias, privateKeyPassphrase.toCharArray());
			if (privateKey instanceof RSAPrivateKey) {
				return (RSAPrivateKey) privateKey;
			}
		} catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException exception) {
			LOG.error("Unable to recover private key from keystore: {}", keyStorePath, exception);
		}
		throw new IllegalArgumentException("Unable to recover private key");
	}

	@Bean
	public RSAPublicKey jwtValidationKey(KeyStore keyStore) {
		try {
			Certificate certificate = keyStore.getCertificate(keyAlias);
			PublicKey publicKey = certificate.getPublicKey();
			if (publicKey instanceof RSAPublicKey) {
				return (RSAPublicKey) publicKey;
			}
		} catch (KeyStoreException exception) {
			LOG.error("Unable to recover public key from keystore: {}", keyStorePath, exception);
		}
		throw new IllegalArgumentException("Unable to recover public key");
	}

	@Bean
	public JwtDecoder jwtDecoder(RSAPublicKey publicKey) {
		return NimbusJwtDecoder.withPublicKey(publicKey).build();
	}

	// @Override
	// protected UserDetailsService userDetailsService() {
	// return userDetailsService;
	// }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

	private Converter<Jwt, AbstractAuthenticationToken> getJwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

		grantedAuthoritiesConverter.setAuthorityPrefix(AUTHORITY_PREFIX);
		grantedAuthoritiesConverter.setAuthoritiesClaimName(ROLES_CLAIM);

		JwtAuthenticationConverter authConverter = new JwtAuthenticationConverter();

		authConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);

		return authConverter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.disable()
			.formLogin()
			.disable()
			.csrf()
			.disable()
			// .ignoringAntMatchers("*/**")
			// .and()
			.cors()
			.and()
			.headers()
			.frameOptions()
			.sameOrigin()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, SIGN_IN_URL)
			.permitAll()
			.antMatchers(HttpMethod.POST, SIGN_UP_URL)
			.permitAll()
			.antMatchers(HttpMethod.POST, TOKEN_URL)
			.permitAll()
			.antMatchers(HttpMethod.DELETE, TOKEN_URL)
			.permitAll()
			.antMatchers(HttpMethod.POST, REFRESH_URL)
			.permitAll()
			.mvcMatchers(HttpMethod.POST, "/admin") // ! Just kidding change this, if you find something useful
			.hasAuthority(Roles.ADMIN.getAuthority())
			.anyRequest()
			.authenticated()
			.and()
			.oauth2ResourceServer(
				resourceServer -> resourceServer
					.jwt(jwt -> jwt.jwtAuthenticationConverter(getJwtAuthenticationConverter()))
			)
			// ? .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) By Default
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
