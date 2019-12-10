package org.bedu.ejemplo03;

import org.bedu.ejemplo03.Repositories.InstructorRepository;
import org.bedu.ejemplo03.Repositories.StudentRepository;
import org.bedu.ejemplo03.Repositories.UserRepository;
import org.bedu.ejemplo03.documents.Instructor;
import org.bedu.ejemplo03.documents.Student;
import org.bedu.ejemplo03.documents.User;
import org.bedu.ejemplo03.enums.Gender;
import org.bedu.ejemplo03.exceptions.InconsistenceException;
import org.bedu.ejemplo03.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class Ejemplo03Application implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private StudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(Ejemplo03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        mongoTemplate.dropCollection("instructors");
        mongoTemplate.dropCollection("students");
        mongoTemplate.dropCollection("users");

        User userInstructor = new User(null, "sonia.25", "sonia123@email.com", "no-segura", new Date(), new Date());
        userInstructor = userRepository.save(userInstructor);

        if (userInstructor.getId().isEmpty())
            throw new PersistenceException("Error al crear usuario");

        Instructor instructor = new Instructor(null, userInstructor, "Sonia", "Rodriguez", "Ing. en sistemas", false);
        instructor = instructorRepository.save(instructor);

        if (instructor.getId().isEmpty())
            throw new PersistenceException("Error al crear instructor");

        User userStudent = new User(null, "hector21", "hector-silva@mail.com", "tamapoco-segura", new Date(), new Date());
        userStudent = userRepository.save(userStudent);

        if (userStudent.getId().isEmpty())
            throw new PersistenceException("Error al crear usuario");

        Student student = new Student(null, userStudent, "Hector", "Silva", new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-19"), "Redes", 56.5f, 172f, Gender.FEMALE);
        student = studentRepository.save(student);
        if (student.getId().isEmpty())
            throw new PersistenceException("Error al crear estudiante");

        //        Instructor sonia = instructorRepository.findFirstByUserUsername("sonia.25");
        Instructor sonia = mongoTemplate.findOne(new Query(where("user.username").is("sonia.25")), Instructor.class);

        if (!sonia.getUser().getUsername().equals("sonia.25"))
            throw new InconsistenceException("Algo anda mal con la búsqueda de instructores por nombre de usuario");

        //        List<Instructor> engComp = instructorRepository.findAllByDegree("Ing. en sistemas");
        List<Instructor> engComp = mongoTemplate.find(new Query(where("degree").is("Ing. en sistemas")), Instructor.class);
        if (engComp.isEmpty())
            throw new InconsistenceException("Algo anda mal con la búsqueda de instructores por carrera prof.");

        System.out.println();
        engComp.forEach(System.out::println);

        //        List<Instructor> instByName = instructorRepository.queryCustomFindByName("Sonia");
        List<Instructor> instByName = mongoTemplate.find(new Query(where("name").is("Sonia")), Instructor.class);
        System.out.println(instByName.size() + " sonias");

    }
}
