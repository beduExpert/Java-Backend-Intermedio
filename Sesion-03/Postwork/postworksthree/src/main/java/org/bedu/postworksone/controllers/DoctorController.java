package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;

	@GetMapping("/{id}")
	Doctor getDoctor(@PathVariable String id) {
		return doctorRepository.findById(id).get();
	}
	
	@PostMapping
	Doctor saveDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@DeleteMapping("/{id}")
	void deleteDoctor(@PathVariable String id) {
		 doctorRepository.deleteById(id);
	}
	
	@PutMapping
	Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
