package org.bedu.ejemplo02;

import org.bedu.ejemplo02.Repositories.UserRepository;
import org.bedu.ejemplo02.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

@SpringBootApplication
public class Ejemplo02Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ejemplo02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection("users");

        User user1 = new User(null, "rosaHdez", "rosa.hdez@email.com", "nosegura", new Date(), new Date());
        user1 = userRepository.save(user1);
        userRepository.save(
            new User(null, "rosaHdez2", "rosa.hdez@email.com", "nosegura2", new Date(), new Date())
        );

        User user2 = new User(null, "hernan.123", "hernan.321@email.com", "tampocosegura", new Date(), new Date());
        user2 = userRepository.save(user2);

        User userByEmail = userRepository.findFirstByEmail("rosa.hdez@email.com");
        System.out.println(userByEmail);

        if (userByEmail.equals(user1))
            System.out.println("Búsqueda por email aprobada");

        if (userRepository.findFirstByUsername("hernan.123").equals(user2))
            System.out.println("Búsqueda por usuario aprobada");

    }
}
