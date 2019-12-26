package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.MedicationDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicationDetailRepository extends MongoRepository<MedicationDetail, String> {
}
