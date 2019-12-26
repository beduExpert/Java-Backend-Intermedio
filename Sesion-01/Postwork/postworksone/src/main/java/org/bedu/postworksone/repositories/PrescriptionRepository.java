package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
}
