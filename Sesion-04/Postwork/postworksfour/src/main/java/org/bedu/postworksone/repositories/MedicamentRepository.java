package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Medicament;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MedicamentRepository extends ReactiveMongoRepository<Medicament, String> {
}
