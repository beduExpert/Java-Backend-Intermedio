package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.Medicament;
import org.bedu.postworksone.repositories.MedicamentRepository;
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
@RequestMapping("/Medicament")
public class MedicamentController {

	@Autowired
	MedicamentRepository medicamentRepository;

	@GetMapping("/{id}")
	Medicament getMedicament(@PathVariable String id) {
		return medicamentRepository.findById(id).get();
	}
	
	@PostMapping
	Medicament saveMedicament(@RequestBody Medicament medicament) {
		return medicamentRepository.save(medicament);
	}
	
	@DeleteMapping("/{id}")
	void deleteMedicament(@PathVariable String id) {
		 medicamentRepository.deleteById(id);
	}
	
	@PutMapping
	Medicament updateMedicament(@RequestBody Medicament medicament) {
		return medicamentRepository.save(medicament);
	}
}
