package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.rest.exceptions.RestException;
import com.example.rest.model.Autor;
import com.example.rest.services.AutorService;

@RestController
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping("/getAutor/{id}")
	public Autor getAutor(@PathVariable Long id) {
		try {
			return autorService.getAutor(id);
		} catch (RestException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping("/saveAutor")
	public Autor saveAutor(@RequestBody Autor autor) {
		return autorService.saveAutor(autor);
	}
	
	@PutMapping("/updateAutor")
	public Autor updateAutor(@RequestBody Autor autor) {
		return autorService.updateAutor(autor);
	}
	
	@DeleteMapping("/deleteAutor/{id}")
	public void deleteAutor(@PathVariable Long id) {
		try {
			autorService.deleteAutor(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
