package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Disease;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DiseaseRepository extends ReactiveMongoRepository<Disease, String> {
}
