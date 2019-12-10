package com.example.rest;

import lombok.Data;

@Data
public class User {
	
	private int id;
	private String username;
	private String phone;
	private String website;
	private Address address;
	private Company company;

}
