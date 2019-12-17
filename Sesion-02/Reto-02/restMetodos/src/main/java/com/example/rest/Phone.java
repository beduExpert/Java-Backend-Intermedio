package com.example.rest;

import lombok.Data;

@Data
public class Phone {
	

	private long id;	
	private int number;
	
	public Phone() {
	}
	
	public Phone(int number) {
		this.number = number;
	}


}
