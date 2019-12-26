package org.bedu.postworksone.services;

import java.util.Arrays;
import java.util.List;

import org.bedu.postworksone.documents.Patient;
import org.bedu.postworksone.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MappingServiceImpl implements MappingService{

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> mappingPatient() {
		RestTemplate restTemplate = new RestTemplate();
		Patient[] patient = restTemplate.getForObject("http://www.mocky.io/v2/5dfceee031000006aad2c280", Patient[].class);
		
		return patientRepository.saveAll(Arrays.asList(patient));
	}
	
	
	
}
