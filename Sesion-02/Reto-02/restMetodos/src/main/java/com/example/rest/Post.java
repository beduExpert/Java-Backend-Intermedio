package com.example.rest;

import lombok.Data;

@Data
public class Post {

	private int userId; 
	private int id;
	private String title;
	private String body;
	
	public Post() {

	}
	
	public Post(int userId, int id,String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}


	public Post(int userId, String title, String body) {
		this.userId = userId;
		this.title = title;
		this.body = body;
	}


	
	
}
