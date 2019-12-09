package com.example.rest.services;

import com.example.rest.exceptions.RestException;
import com.example.rest.model.Libro;

public interface LibroService {

	Libro saveLibro(Libro Libro);
	
	Libro getLibro(Long id) throws RestException;
	
	Libro updateLibro(Libro Libro);
	
	void deleteLibro(Long id);
}
