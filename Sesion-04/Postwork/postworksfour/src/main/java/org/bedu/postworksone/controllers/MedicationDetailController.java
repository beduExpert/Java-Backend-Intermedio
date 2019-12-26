package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.MedicationDetail;
import org.bedu.postworksone.repositories.MedicationDetailRepository;
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
@RequestMapping("/MedicationDetail")
public class MedicationDetailController {

	@Autowired
	MedicationDetailRepository medicationDetailRepository;

	@GetMapping("/{id}")
	Mono<MedicationDetail> getMedicationDetail(@PathVariable String id) {
		return medicationDetailRepository.findById(id);
	}
	
	@PostMapping
	Mono<MedicationDetail> saveMedicationDetail(@RequestBody MedicationDetail medicationDetail) {
		return medicationDetailRepository.save(medicationDetail);
	}
	
	@DeleteMapping("/{id}")
	void deleteMedicationDetail(@PathVariable String id) {
		 medicationDetailRepository.deleteById(id);
	}
	
	@PutMapping
	Mono<MedicationDetail> updateMedicationDetail(@RequestBody MedicationDetail medicationDetail) {
		return medicationDetailRepository.save(medicationDetail);
	}
}
