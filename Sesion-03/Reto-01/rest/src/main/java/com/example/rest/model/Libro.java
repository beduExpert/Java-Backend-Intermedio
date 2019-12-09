package com.example.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LIBRO")
@Data
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	
	private String editorial;
	
	private int precio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_autor")
	private Autor autor;
}
