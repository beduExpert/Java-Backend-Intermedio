## Postwork Sesión 6

A lo largo de este proyecto reafirmaremos lo que se ha aprendido durante las sesiones.

### Módulo 6 - Apache Kafka

- Continuamos con el postwork de la sesion 5.
- Se crean los siguientes archivos

```java
package org.bedu.postworksone.kafka.serializer;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.protos.DoctorProtoConverter;

import java.util.Map;

public class KafkaDoctorSerializer implements Serializer<Doctor> {

    @Override
    public byte[] serialize(String s, Doctor doctor) {

        return DoctorProtoConverter.from(doctor).toByteArray();
    }


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //Nothing to do, this serializer does not need extra configuration
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Doctor data) {
        return DoctorProtoConverter.from(data).toByteArray();
    }

    @Override
    public void close() {
        //Nothing to do, this serializer does not need to release resources
    }
}
```
```java
package org.bedu.postworksone.protos;

import lombok.experimental.UtilityClass;
import org.bedu.postworksone.documents.Doctor;
import org.bedu.postworksone.protos.models.DoctorProto;

@UtilityClass
public class DoctorProtoConverter {
    public DoctorProto.Doctor from(Doctor doctor) {
        DoctorProto.Doctor.Builder builder = DoctorProto.Doctor.newBuilder();

        builder.setId(doctor.getId())
                .setName(doctor.getName())
                .setLastname(doctor.getLastname())
                .setBirthday(doctor.getBirthday().toString())
                .setSpecialized(doctor.isSpecialized())
                .setYearsExperience(doctor.getYearsExperience());

        if (doctor.isSpecialized() && !doctor.getSpeciality().isBlank()) {
            builder.setSpeciality(doctor.getSpeciality());
        }

        return builder.build();
    }
}

```

- Modificamos el archivo _application.properties_
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/postwork_sesion_cinco
logging.level.org.springframework.data.mongodb.core.MongoTemplate=DEBUG
#Kafka
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.value-serializer=org.bedu.postworksone.kafka.serializer.KafkaDoctorSerializer
```
- Y hacemos uso de DoctorServiceImpl para enviar el registro al servidor kafka
```java
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
```

**Nota** Debes iniciar el servidor Apache Kafka y crear el tópico como se hizo en los ejercicios

### Contexto general

El dueño del sistema desea tener el registro de todos los doctores dados de alta en un servidor de Apache Kafka, esto para alimentar otros sistemas que puede monetizar y necesitan estar actualizados.

El servidor existe en localhost:9092 y tiene un tópico llamado _doctors_.

### Resultado esperado

Al finalizar este ejercicio se debe recibir la información de cada nuevo registro cuando se ejecuta el siguiente comando

```bash
    bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic doctors
```
