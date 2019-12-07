package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User findOneByUsername(String username);
    public User findOneByEmail(String email);
}
