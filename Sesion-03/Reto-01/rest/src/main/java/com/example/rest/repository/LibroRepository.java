package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.Libro;

@Repository
public interface LibroRepository  extends JpaRepository<Libro, Long>{
	
	

}
