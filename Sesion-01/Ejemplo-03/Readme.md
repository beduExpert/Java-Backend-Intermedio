## Ejemplo 3: 

### Objetivo
- Aplicar sentencias avanzadas mongoDB desde Spring
- Reafirmar conceptos de búsqueda de MongoDB desde Spring

### Requisitos
- MongoDB instalado
- JDK 8 o superior
- IDE de tu preferencia
- mongodb compass (Recomendado pero no necesario)

### Desarrollo

1. A partir del proyecto anterior si se desea (o crear uno nuevo) crear una entidad para mapear a un documento llamado `instructors`:


```java

package org.bedu.ejemplo03.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instructor {
    @Id
    private String id;

    private User user;

    private String name;
    private String lastname;
    private String degree;

    @Getter(AccessLevel.NONE)
    private boolean certified;

    public boolean isCertified(){
        return this.certified;
    }
}

```

2. Hacer lo mismo para un documento llamado `students`:

```java
package org.bedu.ejemplo03.documents;

import lombok.*;
import org.bedu.ejemplo03.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    private String id;

    private User user;

    private String name;
    private String lastname;
    private Date birthdate;
    private String course;
    private Float weigth;
    private Float stature;
    private Gender gender;
}

```

3. Crear sus respectivos repositorios con esta estructura:

```java
package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor, String> {
    public List<Instructor> findAllByDegree(String degree);
    public Instructor findOneByUserUsername(String username);
}

```

```java
package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}

```

4. Modificar el repositorio de la entidad User (`UserRepository`) de la siguiente manera:

```java
package org.bedu.ejemplo03.Repositories;

import org.bedu.ejemplo03.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User findOneByUsername(String username);
    public User findOneByEmail(String email);
}

```

4. Agregar a la clase principal (Marcada con la anotación `@SpringBootApplication`) lo siguiente:

```java
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

        Instructor sonia = instructorRepository.findOneByUserUsername("sonia.25");

        if (!sonia.getUser().getUsername().equals("sonia.25"))
            throw new InconsistenceException("Algo anda mal con la búsqueda de instructores por nombre de usuario");

        List<Instructor> engComp = instructorRepository.findAllByDegree("Ing. en sistemas");
        if (engComp.isEmpty())
            throw new InconsistenceException("Algo anda mal con la búsqueda de instructores por carrera prof.");

        System.out.println();
        engComp.forEach(System.out::println);

    }
}

```
5. Para observar con mejor detalle lo que sucede en la base de datos, agregar la siguiente configuración en el archivo de propiedades:

```
logging.level.org.springframework.data.mongodb.core.MongoTemplate=DEBUG
```

6. Ejecutar la aplicación, y comprobar que no existe ningún error además de verificar los logs en la consola y que en la base de datos Mongo existen tres colecciones con sus respectivos documentos.
