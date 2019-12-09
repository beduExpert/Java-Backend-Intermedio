package com.example.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.exceptions.RestException;
import com.example.rest.model.Libro;
import com.example.rest.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public Libro saveLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public Libro getLibro(Long id) throws RestException {
		if(!libroRepository.existsById(id)) {
			throw new RestException("Se requiere un Id existente para obtener el libro.");
		}else {
			return libroRepository.getOne(id);
		}
		
	}

	@Override
	public Libro updateLibro(Libro libro){
		return libroRepository.save(libro);
	}

	@Override
	public void deleteLibro(Long id){
		libroRepository.deleteById(id);
	}

}
