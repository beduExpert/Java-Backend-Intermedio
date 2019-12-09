package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
