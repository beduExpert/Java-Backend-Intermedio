package org.bedu.postworksone.servicesImpl.protobufServiceImpl;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.protos.DoctorProtoConverter;
import org.bedu.postworksone.protos.models.DoctorProto;
import org.bedu.postworksone.repositories.DoctorRepository;
import org.bedu.postworksone.services.protobufservices.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("doctorService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Mono<DoctorProto.Doctor> obtenerPorId(String id) {

        return doctorRepository.findById(id).map(DoctorProtoConverter::from);
    }


    @Override
    public Flux<DoctorProto.Doctor> obtenerTodos() {
        return doctorRepository.findAll().map(DoctorProtoConverter::from);
    }

}
