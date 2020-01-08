package org.bedu.postworksone.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.bedu.postworksone.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("doctorServiceProtobuf")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Mono<Doctor> obtenerPorId(String id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Flux<Doctor> obtenerTodos() {
        return doctorRepository.findAll();
    }
}
