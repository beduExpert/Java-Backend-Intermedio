## Ejemplo 03: Consumidor de Kafka con Java

### Objetivo
1. Configurar un proyecto Java para que funcione como consumidor

### Procedimiento


#### Crea el proyecto
1. En [Spring Initializr](https://start.spring.io) crea un proyecto con las siguientes dependencias
    * Spring Apache Kafka
    * Lombok (opcional)
2. Carga el proyeco en tu IDE



#### Configuraciones

**Nota** Se asume que se tiene en ejecución el servidor de kafka del Ejemplo 1, con el tópico bedu-msg; y el proyecto productor del Ejemplo 2.

1. Abre el archivo application.properties y agrega el siguiente valor
```
spring.kafka.bootstrap-servers: localhost:9092
spring.kafka.consumer.group-id=demo-consumer

logging.level.com.example.demo.kafkaproducer=DEBUG
server.port=8081
```

Las últimas opciones son apra establecer el nivel de log en DEBUG y para cambiar el puerto de ejecución (para evitar conflicto con el proyecto del productor)

#### Consumidor
1. Crea una clase con el siguiente contenido
```java
@Component
@Slf4j
public class ModelListener {

    @KafkaListener(topics = {"bedu-msg"})
    public void methodListener(String message){

       log.debug("Mensaje Recibido :: {}", message);

    }


}
```
Con esto, spring ejecutará el método anotado cada vez que se reciba un mensaje del tópico especificado.

### Prueba

Envía un mensaje a la url _[POST] http://localhost:8080/kafka?m=Mensaje_ (eta corresponde al productor del Ejemplo 2).

En la consola del consumidor verás el mensaje recibido.

```bash
2019-12-09 11:18:07.671 DEBUG 5097 --- [ntainer#0-0-C-1] c.e.d.k.kafka.listener.ModelListener     : Mensaje Recibido :: Hola
```
