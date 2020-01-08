## Postwork Sesión 5

A lo largo de este proyecto reafirmaremos lo que se ha aprendido durante las sesiones.

### Módulo 5 - Protocol Buffers

- Continuamos con el postwork de la sesion 4.
- Solo modificaremos la clase principal (anotada con `@SpringBootApplication`) para que quede de la siguiente manera:

```java
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

```

### Contexto general

El dueño del sistema ha decidido abrir un nuevo hospital, sin embargo, este nuevo hospital será más sofisticado tecnológicamente.

El nuevo proyecto ya ha sido asignado ya a otro equipo de desarrollo. El equipo de desarrollo mencionado trabaja con protocol buffers.

Tambien te mencionaron que el nuevo hospital tendrá más datos de sus doctores con el paso del tiempo (la estructura de los doctores del nuevo hospital no será siempre la misma que la del hospital actual, con el tiempo se podrán agregar datos).

Se te ha encomendado una tarea inicial de proporcionarles un acceso a los doctores del hospital actual con la diferencia de que en lugar de enviarles las respuestas en JSON, la requieren serializadas mediante Protocol Buffers. Obviamente no se debe modificar la funcionalidad actual del sistema (Open/close principle).

### Resultado esperado

Al finalizar la tarea se espera que al consultar el siguiente endpoint:
`localhost:8080/protobuf/doctor/{idDoctor}` se retornen los datos del doctor pero serializados con Protocol Buffers. 

De igual manera, el endpoint `localhost:8080/Doctor/{idDoctor}` no debería verse afectado y debería seguir devolviendo los datos en JSON (para el hospital actual).
