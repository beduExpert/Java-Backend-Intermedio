package org.bedu.ejemplo02;

import org.bedu.ejemplo02.Repositories.UserRepository;
import org.bedu.ejemplo02.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
public class Ejemplo02Application implements CommandLineRunner {

    private final Logger log = Logger.getLogger(this.getClass().getName());

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

        User user = new User(null, "rosaHdez", " rosa.hdez@email.com", "nosegura", new Date(), new Date());
        user = userRepository.save(user);
        log.info(user.toString());
    }
}
