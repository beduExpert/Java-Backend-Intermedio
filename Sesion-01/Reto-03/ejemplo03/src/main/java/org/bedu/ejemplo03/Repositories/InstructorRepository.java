package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.Instructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor, String> {
    public List<Instructor> findAllByDegree(String degree);

    public Instructor findFirstByUserUsername(String username);

    @Query(value = "{ 'name': ?0 }")
    public List<Instructor> queryCustomFindByName(String name);
}
