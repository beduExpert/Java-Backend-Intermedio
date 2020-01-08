package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DoctorRepository extends ReactiveMongoRepository<Doctor, String> {
}
