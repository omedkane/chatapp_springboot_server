package mr.gk2ms.chatapp.configurations;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class AppConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		Map<String, PasswordEncoder> encoders = Map
			.of(
				"bcrypt",
				new BCryptPasswordEncoder(),
				"pbkdf2",
				new Pbkdf2PasswordEncoder(),
				"scrypt",
				new SCryptPasswordEncoder()
			);

		return new DelegatingPasswordEncoder("bcrypt", encoders);
	}
}
