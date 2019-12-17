package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestMetodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMetodosApplication.class, args);
		

		RestTemplate restTemplate = new RestTemplate();
		
		//post
		  restTemplate = new RestTemplate();
		  HttpEntity<User> request2 = new HttpEntity<>(new User("Test", "test@test.com"));
		  User user = restTemplate.postForObject("http://localhost:8081/users", request2, User.class);
		
		  System.out.println("POST " + user);
		  
		//get
			restTemplate = new RestTemplate();
			user = restTemplate.getForObject("http://localhost:8081/users/1", User.class);
			  
			System.out.println("GET "+ user);

			//put
			  restTemplate = new RestTemplate();
			  request2 = new HttpEntity<>(new User(1,"Test put", "test@test.com"));
			  HttpEntity<User> response2 = restTemplate.exchange("http://localhost:8081/users/1", HttpMethod.PUT ,request2, User.class);
			
			  System.out.println("PUT " + response2.getBody());
			  
			//delete
			  restTemplate.delete("http://localhost:8081/users/1");
	}

}
