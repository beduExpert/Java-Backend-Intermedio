package org.bedu.postworksone.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.bedu.postworksone.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("doctorServiceProtobuf")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DoctorServiceImpl implements DoctorService {
    private static final String TOPIC_NAME = "doctors";

    private final DoctorRepository doctorRepository;
    private final KafkaTemplate<String, Doctor> kafkaTemplate;

    private String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public Mono<Doctor> obtenerPorId(String id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Flux<Doctor> obtenerTodos() {
        return doctorRepository.findAll();
    }

    @Override
    public Mono<Doctor> saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor).map(d -> {
            kafkaTemplate.send(TOPIC_NAME, getDate(), d);
            return d;
        });
    }

    @Override
    public void delete(String id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Mono<Doctor> updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
