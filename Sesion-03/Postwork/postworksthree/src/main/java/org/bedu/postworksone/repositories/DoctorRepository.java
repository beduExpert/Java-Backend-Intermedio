package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
