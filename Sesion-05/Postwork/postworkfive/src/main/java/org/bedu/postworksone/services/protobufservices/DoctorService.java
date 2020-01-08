package org.bedu.postworksone.services.protobufservices;

import org.bedu.postworksone.protos.models.DoctorProto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DoctorService {

    Mono<DoctorProto.Doctor> obtenerPorId(String id);

    Flux<DoctorProto.Doctor> obtenerTodos();

}
