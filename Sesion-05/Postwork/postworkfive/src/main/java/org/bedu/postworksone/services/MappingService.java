package org.bedu.postworksone.services;


import org.bedu.postworksone.documents.Patient;

import reactor.core.publisher.Flux;

public interface MappingService {

	Flux<Patient> mappingPatient();
}
