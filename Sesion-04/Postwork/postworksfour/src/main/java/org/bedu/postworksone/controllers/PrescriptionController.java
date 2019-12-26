package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.Prescription;
import org.bedu.postworksone.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Prescription")
public class PrescriptionController {

	@Autowired
	PrescriptionRepository prescriptionRepository;

	@GetMapping("/{id}")
	Mono<Prescription> getPrescription(@PathVariable String id) {
		return prescriptionRepository.findById(id);
	}
	
	@PostMapping
	Mono<Prescription> savePrescription(@RequestBody Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	@DeleteMapping("/{id}")
	void deletePrescription(@PathVariable String id) {
		 prescriptionRepository.deleteById(id);
	}
	
	@PutMapping
	Mono<Prescription> updatePrescription(@RequestBody Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
}
