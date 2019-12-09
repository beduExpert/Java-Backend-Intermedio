package com.example.rest.services;

import com.example.rest.exceptions.RestException;
import com.example.rest.model.Autor;

public interface AutorService {

	Autor saveAutor(Autor autor);
	
	Autor getAutor(Long id) throws RestException;
	
	Autor updateAutor(Autor autor);
	
	void deleteAutor(Long id);
}
