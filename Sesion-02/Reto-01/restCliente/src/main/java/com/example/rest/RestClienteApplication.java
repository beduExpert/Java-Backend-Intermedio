package com.example.rest;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClienteApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		  User[] users = restTemplate
		    .getForObject("https://jsonplaceholder.typicode.com/users", User[].class);
		  
		  for(User user : users) {
			  System.out.println(user);
		  }
	}

}
