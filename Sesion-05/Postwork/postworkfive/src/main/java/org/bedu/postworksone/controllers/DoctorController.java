package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController("doctorController")
@RequestMapping("/Doctor")
public class DoctorController {

	@Autowired
	DoctorRepository doctorRepository;

	@GetMapping("/{id}")
	Mono<Doctor> getDoctor(@PathVariable String id) {
		return doctorRepository.findById(id);
	}
	
	@PostMapping
	Mono<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@DeleteMapping("/{id}")
	void deleteDoctor(@PathVariable String id) {
		 doctorRepository.deleteById(id);
	}
	
	@PutMapping
	Mono<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
