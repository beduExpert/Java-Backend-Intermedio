package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseRepository extends MongoRepository<Disease, String> {
}
