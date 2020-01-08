package org.bedu.postworksone.services;

import org.bedu.postworksone.documents.Doctor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DoctorService {

    Mono<Doctor> obtenerPorId(String id);

    Flux<Doctor> obtenerTodos();
}
