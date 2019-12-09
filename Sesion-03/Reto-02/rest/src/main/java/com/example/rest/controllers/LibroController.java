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
import com.example.rest.model.Libro;
import com.example.rest.repository.LibroRepository;
import com.example.rest.services.LibroService;

@RestController
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("/getLibro/{id}")
	public Libro getLibro(@PathVariable Long id) {
		try {
			return libroService.getLibro(id);
		} catch (RestException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping("/saveLibro")
	public Libro saveLibro(@RequestBody Libro Libro) {
		return libroService.saveLibro(Libro);
	}
	
	@PutMapping("/updateLibro")
	public Libro updateLibro(@RequestBody Libro Libro) {
		return libroService.saveLibro(Libro);
	}
	
	@DeleteMapping("/deleteLibro/{id}")
	public void deleteLibro(@PathVariable Long id) {
		libroService.deleteLibro(id);
	}
}
