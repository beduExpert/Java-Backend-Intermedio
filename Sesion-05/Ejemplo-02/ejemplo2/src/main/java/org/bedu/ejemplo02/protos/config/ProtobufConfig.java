package org.bedu.ejemplo02.protos.config;

import java.util.HashMap;
import java.util.Map;

import org.bedu.ejemplo02.protos.models.LoginProto;
import org.bedu.ejemplo02.protos.models.LoginProto.Gender;
import org.bedu.ejemplo02.protos.models.LoginProto.User;
import org.bedu.ejemplo02.protos.repository.VirtualUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtobufConfig {
	
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	private LoginProto.User newUser(int id, String nombre, String email, String password) {

		return LoginProto.User.newBuilder()
			.setId(id)
			.setName(nombre)
			.setEmail(email)
			.setPassword(password)
		.build();
	}

	@Bean
	public VirtualUserRepository createUsers() {
		Map<Integer, User> users = new HashMap<>();
		
		User user = newUser(1, "Hernan", "hernan.123@mail.com", "nosegura");
		users.put(user.getId(), user);
		
		user = newUser(2, "Mary", "mary.ros@email.com", "pass");
		users.put(user.getId(), user);
		
		user = newUser(3, "Jose", "jos.091@email.com", "contras23");
		users.put(user.getId(), user);
		
		return new VirtualUserRepository(users);
	}
}

