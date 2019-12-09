package com.example.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.exceptions.RestException;
import com.example.rest.model.Autor;
import com.example.rest.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor getAutor(Long id) throws RestException {
		if(!autorRepository.existsById(id)) {
			throw new RestException("Se requiere un Id existente para obtener el autor.");
		}else {
			return autorRepository.getOne(id);
		}
		
	}

	@Override
	public Autor updateAutor(Autor autor){
		return autorRepository.save(autor);
	}

	@Override
	public void deleteAutor(Long id){
		autorRepository.deleteById(id);
	}

}
