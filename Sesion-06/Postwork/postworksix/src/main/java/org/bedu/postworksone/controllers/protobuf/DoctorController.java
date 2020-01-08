package org.bedu.postworksone.controllers.protobuf;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.protos.models.DoctorProto;
import org.bedu.postworksone.services.protobufservices.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("doctorControllerProtobuf")
@RequestMapping("/protobuf/doctor")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("")
    public Flux<DoctorProto.Doctor> getAllDoctors(){
        return doctorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Mono<DoctorProto.Doctor> getDoctor(@PathVariable  String id){
        return doctorService.obtenerPorId(id);
    }

}
