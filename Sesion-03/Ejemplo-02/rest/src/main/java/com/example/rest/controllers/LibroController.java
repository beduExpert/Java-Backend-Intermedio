package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Libro;
import com.example.rest.repository.LibroRepository;

@RestController
public class LibroController {

	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping("/getLibro/{id}")
	public Libro getLibro(@PathVariable Long id) {
		return libroRepository.getOne(id);
	}
	
	@PostMapping("/saveLibro")
	public Libro saveLibro(@RequestBody Libro Libro) {
		return libroRepository.save(Libro);
	}
	
	@PutMapping("/updateLibro")
	public Libro updateLibro(@RequestBody Libro Libro) {
		return libroRepository.save(Libro);
	}
	
	@DeleteMapping("/deleteLibro/{id}")
	public void deleteLibro(@PathVariable Long id) {
		libroRepository.deleteById(id);
	}
}
