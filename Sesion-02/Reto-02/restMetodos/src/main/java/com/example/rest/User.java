package com.example.rest;

import java.util.List;

import lombok.Data;

@Data
public class User {

	private long id;	
	private String name;
	private String email;
	
	private List<Phone> phones;
	
	public User() {
	}
	
	public User(long id, String name, String email, List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phones = phones;
	}

	public User(String name, String email, List<Phone> phones) {
		super();
		this.name = name;
		this.email = email;
		this.phones = phones;
	}
	
}
