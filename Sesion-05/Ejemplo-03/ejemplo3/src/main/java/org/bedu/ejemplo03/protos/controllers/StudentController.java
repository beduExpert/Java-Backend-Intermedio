package org.bedu.ejemplo03.protos.controllers;

import org.bedu.ejemplo03.protos.models.LoginProto;
import org.bedu.ejemplo03.protos.repository.VirtualStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private VirtualStudentRepository studentRepository;

	@RequestMapping("/student/{id}")
	LoginProto.Student student(@PathVariable Integer id) {
		return this.studentRepository.getStudent(id);
	}
}
