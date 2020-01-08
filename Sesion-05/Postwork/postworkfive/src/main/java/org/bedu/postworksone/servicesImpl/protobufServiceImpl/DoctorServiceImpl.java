package org.bedu.postworksone.servicesImpl.protobufServiceImpl;

import lombok.RequiredArgsConstructor;
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

        return doctorRepository.findById(id).map(doctor -> {
            DoctorProto.Doctor.Builder dr = DoctorProto.Doctor.newBuilder();
            if (doctor.isSpecialized())
                dr.setSpeciality(doctor.getSpeciality());

            return dr.setId(doctor.getId())
                    .setName(doctor.getName())
                    .setLastname(doctor.getLastname())
                    .setBirthday(doctor.getBirthday().toString())
                    .setSpecialized(doctor.isSpecialized())
                    .setYearsExperience(doctor.getYearsExperience())
                    .build();
        });
    }

    @Override
    public Flux<DoctorProto.Doctor> obtenerTodos() {
        return doctorRepository.findAll().map(doctor -> {
            DoctorProto.Doctor.Builder dr = DoctorProto.Doctor.newBuilder();
            if (doctor.isSpecialized())
                dr.setSpeciality(doctor.getSpeciality());

            return dr.setId(doctor.getId())
                    .setName(doctor.getName())
                    .setLastname(doctor.getLastname())
                    .setBirthday(doctor.getBirthday().toString())
                    .setSpecialized(doctor.isSpecialized())
                    .setYearsExperience(doctor.getYearsExperience())
                    .build();
        });
    }
}
