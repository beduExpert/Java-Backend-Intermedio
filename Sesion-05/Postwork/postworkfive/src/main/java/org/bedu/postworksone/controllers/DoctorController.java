package org.bedu.postworksone.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("doctorController")
@RequestMapping("/Doctor")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DoctorController {

    private final DoctorService service;

    @GetMapping
    Flux<Doctor> getAllDoctors(){
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    Mono<Doctor> getDoctor(@PathVariable String id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    Mono<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        return service.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    void deleteDoctor(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping
    Mono<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return service.updateDoctor(doctor);
    }
}
