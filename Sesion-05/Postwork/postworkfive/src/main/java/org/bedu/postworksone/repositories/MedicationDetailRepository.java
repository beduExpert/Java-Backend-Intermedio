package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.MedicationDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MedicationDetailRepository extends ReactiveMongoRepository<MedicationDetail, String> {
}
