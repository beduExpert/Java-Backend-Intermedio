package org.bedu.ejemplo03;

import static org.assertj.core.api.Assertions.assertThat;

import org.bedu.ejemplo03.protos.models.LoginProto.Student;
import org.bedu.ejemplo03.protos.models.LoginProto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@WebAppConfiguration
class SerializationTest {

	private static final String USER_URL = "http://localhost:8080/user/2";
	private static final String STUDENT_URL = "http://localhost:8080/student/1";

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void getUser() {
		ResponseEntity<User> user = restTemplate.getForEntity(USER_URL, User.class);
		System.out.println(String.format("\n%s \n", user.getBody()));
		assertThat(user).isNotNull();
	}
	
	@Test
	public void getStudent() {
		ResponseEntity<Student> student = restTemplate.getForEntity(STUDENT_URL, Student.class);
		System.out.println(String.format("\n%s \n", student.getBody()));
		assertThat(student).isNotNull();
	}
	
	@Test
	public void getUserOfStudent() {
		ResponseEntity<Student> student = restTemplate.getForEntity(STUDENT_URL, Student.class);
		System.out.println(String.format("\n%s \n", student.getBody()));
		assertThat(student.getBody().getUser().getEmail()).isNotEmpty();
	}

}
