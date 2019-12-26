package org.bedu.postworksone.repositories;

import org.bedu.postworksone.documents.Medicament;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentRepository extends MongoRepository<Medicament, String> {
}
