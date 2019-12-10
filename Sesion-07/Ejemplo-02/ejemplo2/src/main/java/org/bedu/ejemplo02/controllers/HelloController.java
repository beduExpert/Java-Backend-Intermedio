package org.bedu.ejemplo02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class HelloController {

	@GetMapping(value = "hello-world")
	public Message sayHelloWorld() {
		return new Message("Hola mundo!!");
	}

	@Data
	@AllArgsConstructor
	private class Message {
		private String message;
	}
}
