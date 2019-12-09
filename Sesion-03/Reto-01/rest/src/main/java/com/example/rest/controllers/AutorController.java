package com.example.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Autor;
import com.example.rest.repository.AutorRepository;

@RestController
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping("/getAutor/{id}")
	public Autor getAutor(@PathVariable Long id) {
		return autorRepository.getOne(id);
	}
	
	@PostMapping("/saveAutor")
	public Autor saveAutor(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}
	
	@PutMapping("/updateAutor")
	public Autor updateAutor(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}
	
	@DeleteMapping("/deleteAutor/{id}")
	public void deleteAutor(@PathVariable Long id) {
		autorRepository.deleteById(id);
	}
}
