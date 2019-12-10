## Ejemplo 02: Productor de Kafka con Java

### Objetivo
1. Configurar un proyecto Java para que funcione como productor

### Procedimiento


#### Crea el proyecto
2. En [Spring Initializr](https://start.spring.io) crea un proyecto con las siguientes dependencias
    * Spring Apache Kafka
    * Lombok (opcional)
3. Carga el proyeco en tu IDE



#### Controlador
4. Crea un controlador con los siguientes endpoints
```java
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("")
    public void sendMessage(@RequestParam("msg") String message) {
        kafkaProducer.sendMessage(message);
    }

}
```
#### Configuraciones

**Nota** Se asume que se tiene en ejecución el servidor de kafka del Ejemplo 1, con el tópico bedu-msg

5. Abre el archivo application.properties y agrega el siguiente valor
```
spring.kafka.bootstrap-servers: localhost:9092
```

#### Productor
Con la configuración anterior, Spring Boot pone a nuestra disposición una instancia de la clase KafkaTemplate<String, String> que podemos inyectar en nuestras clases para publicar mensajes.

6. Crea una clase con el siguiente contenido

```java
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("bedu-msg",LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) ,message);
    }

}
```
Estamos usando un timestamp como llave para el registro.

Este método enviará el mensaje al servidor de kafka.

Puedes probar el funcionamiento iniciando el servidor y haciendo una petición HTTP a [POST] /kafka?msg=Hola%20Mundo

