package com.example.rest;

import lombok.Data;

@Data
public class User {

	private long id;	
	private String name;
	private String email;
	
	public User() {
		super();
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

}
