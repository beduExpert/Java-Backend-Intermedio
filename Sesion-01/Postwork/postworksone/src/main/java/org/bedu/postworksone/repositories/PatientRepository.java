package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
