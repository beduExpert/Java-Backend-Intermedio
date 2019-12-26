package org.bedu.postworksone.controllers;

import org.bedu.postworksone.documents.Disease;
import org.bedu.postworksone.repositories.DiseaseRepository;
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
@RequestMapping("/Disease")
public class DiseaseController {
	
	@Autowired
	DiseaseRepository diseaseRepository;

	@GetMapping("/{id}")
	Disease getDisease(@PathVariable String id) {
		return diseaseRepository.findById(id).get();
	}
	
	@PostMapping
	Disease saveDisease(@RequestBody Disease disease) {
		return diseaseRepository.save(disease);
	}
	
	@DeleteMapping("/{id}")
	void deleteDisease(@PathVariable String id) {
		 diseaseRepository.deleteById(id);
	}
	
	@PutMapping
	Disease updateDisease(@RequestBody Disease disease) {
		return diseaseRepository.save(disease);
	}
}
