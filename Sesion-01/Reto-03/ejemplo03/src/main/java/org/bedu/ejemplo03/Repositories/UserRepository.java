package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findFirstByUsername(String username);
    public User findFirstByEmail(String email);
}
