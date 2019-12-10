## Procesamiento de streams de kafka con Java

### Objetivo
1. Configurar un proyecto Java para que funcione un procesador de streams en Kafka.

### Procedimiento


#### Crea el proyecto
1. En [Spring Initializr](https://start.spring.io) crea un proyecto con las siguientes dependencias
    * Spring Apache Kafka
    * Spring Apache Kafka Streams
2. Carga el proyeco en tu IDE


#### Configuraciones

**Nota** Se asume que se tienen en ejecución los servicios de todos los ejercicios anteriores.

1. Abre el archivo application.properties y agrega el siguiente valor
```
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.streams.application-id=stream-demo
```

#### Nuevo tópico
1. Crea un nuevo tópico en apache kafka con nombre _bedu-msg-2_
2. Abre una consola de consumidor con el nuevo tópico.

#### Procesador de streams
1. Crea una clase con el siguiente contenido
```java
@Configuration(proxyBeanMethods = false)
@EnableKafkaStreams
public class KafkaStreamConfiguration {

    private static final Logger log = LoggerFactory.getLogger(KafkaStreamConfiguration.class);

    @Bean
    public KStream<String, String> kstream(StreamsBuilder streamsBuilder) {

        KStream<String, String> stream = streamsBuilder.stream("bedu-msg", Consumed.with( Serdes.String(), Serdes.String()))
                .map((key, value) -> new KeyValue<String, String>(key, Integer.toString(value.length())));

        stream.to("bedu-msg-2", Produced.with(Serdes.String(), Serdes.String()));

        return stream;

    }

}
```
Consumed.with significa que esperamos que el registro que se lee tinee una estructura clave, valor donde ambos son strings.
Igualmente Produced.with hace lo propio para el valor de salida.

En este ejemplo no hacemos ninguna conversión de tipo, pero de hacerlo sería aquí donde se indicaría.

Dejamos el tipo en String con fines didácticos, ya que estos son los únicos que se muestran en la consola de consumidor. De otra manera sólo veríamos una nueva línea vacía.

### Prueba

Envía un mensaje a la url _[POST] http://localhost:8080/kafka?m=Mensaje_ (eta corresponde al productor del Ejemplo 2).

En la consola del consumidor verás el valor de la longitud del mensaje enviado.

