package org.bedu.ejemplo02.Repositories;

import org.bedu.ejemplo02.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
