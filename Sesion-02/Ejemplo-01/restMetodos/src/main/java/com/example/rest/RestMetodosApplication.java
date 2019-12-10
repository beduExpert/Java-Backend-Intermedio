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
		
		//get
		RestTemplate restTemplate = new RestTemplate();
		  Post[] posts = restTemplate
		    .getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
		  
		  for(Post post : posts) {
			  System.out.println("GET "+ post);
		  }
		  
		  //post
		  restTemplate = new RestTemplate();
		  HttpEntity<Post> request = new HttpEntity<>(new Post(1,"foo", "barr"));
		  Post post = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", request, Post.class);
		
		  System.out.println("POST " + post);
		  
		//delete
		  restTemplate.delete("https://jsonplaceholder.typicode.com/posts/1");
		
		  
		//put
		  restTemplate = new RestTemplate();
		  request = new HttpEntity<>(new Post(1,1,"foasdldkasdkaso", "barr"));
		  HttpEntity<Post> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT ,request, Post.class);
		
		  System.out.println("PUT " + response.getBody());
	}

}
