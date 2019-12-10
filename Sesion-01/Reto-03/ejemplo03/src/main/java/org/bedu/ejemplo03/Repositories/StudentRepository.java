package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
