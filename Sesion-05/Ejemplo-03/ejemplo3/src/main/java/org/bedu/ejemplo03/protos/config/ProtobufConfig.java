package org.bedu.ejemplo03.protos.config;

import java.util.HashMap;
import java.util.Map;

import org.bedu.ejemplo03.protos.models.LoginProto;
import org.bedu.ejemplo03.protos.models.LoginProto.Gender;
import org.bedu.ejemplo03.protos.models.LoginProto.Student;
import org.bedu.ejemplo03.protos.models.LoginProto.User;
import org.bedu.ejemplo03.protos.repository.VirtualStudentRepository;
import org.bedu.ejemplo03.protos.repository.VirtualUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtobufConfig {
	
	private Map<Integer, User> users = new HashMap<Integer, LoginProto.User>();
	
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
	
	private LoginProto.Student newStudent(int id, LoginProto.User user, int age, float stature, boolean certified, Gender gender ) {

		return LoginProto.Student.newBuilder()
			.setId(id)
			.setUser(user)
			.setAge(age)
			.setStature(stature)
			.setCertified(certified)
			.setGender(gender)
		.build();
	}


	@Bean
	public VirtualUserRepository createUsers() {
		
		if(users.isEmpty()) {
			User user = newUser(1, "Hernan", "hernan.123@mail.com", "nosegura");
			users.put(user.getId(), user);
			
			user = newUser(2, "Mary", "mary.ros@email.com", "pass");
			users.put(user.getId(), user);
			
			user = newUser(3, "Jose", "jos.091@email.com", "contras23");
			
			users.put(user.getId(), user);
			
		}
		return new VirtualUserRepository(users);
	}
	
	@Bean
	public VirtualStudentRepository createStudents() {
		
		if(users.isEmpty())
			createUsers();
		
		Map<Integer, Student> students = new HashMap<>();
		
		Student student = newStudent(1, users.get(1), 19, 171.5f, false, Gender.MALE);
		students.put(1, student);
		
		student = newStudent(2, users.get(2), 32, 163.5f, true, Gender.FEMALE);
		students.put(2, student);
		
		student = newStudent(3, users.get(3), 23, 182f, true, Gender.MALE);
		students.put(3, student);
		
		return new VirtualStudentRepository(students);
	}
}

