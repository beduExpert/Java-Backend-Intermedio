package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Prescription;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PrescriptionRepository extends ReactiveMongoRepository<Prescription, String> {
}
