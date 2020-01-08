package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Patient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PatientRepository extends ReactiveMongoRepository<Patient, String> {
}
