package org.bedu.postworksone;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostworkS1Application implements CommandLineRunner {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private final DoctorRepository doctorRepository;

    public static void main(String[] args) {
        SpringApplication.run(PostworkS1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Doctor doctor = new Doctor(null, "Diana Laura", "García", new SimpleDateFormat(DATE_FORMAT).parse("1995-09-12"), false, null, 1);
        doctorRepository.save(doctor).subscribe();
    }
}
