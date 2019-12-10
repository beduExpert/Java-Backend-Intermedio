## Reto 2

### Objetivos
* Enviar un mensaje con un objeto personalizado serializado

Srping Kafka nos permite implementar un serializador personalizado. Este debe convertir nuestro objeto en un arreglo de bytes.

Si se opta por esta opción se debe registrar el valor _spring.kafka.produce.value-serializer_ con el serializador.

Sin embargo esto nos limita a enviar ese único tipo de dato. 

En este ejercicio optaremos por otra opción.

Usa la clase ObjectMapper de Jackson para serializar un objeto en formato JSON y envíalo como texto.

<details>
  <summary>Solución</summary>

  <ol>
      <li>Crea una clase POJO para el ejercicio
        ```java
       @Data
       public class DataModel implements Serializable {
           private String nombre;
           private Short edad;
       } 
        ```
      </li>
      <li>En la clase KafkaProducer agrega el siguiente método
    ```java
    @SneakyThrows
    public void sendObject(DataModel object) {
        sendMessage(mapper.writeValueAsString(object));
    }

    ```
    donde mapper es una instancia de ObjectMapper;
      </li>
    <li>Agrega este método al controlador
    ```java
    @PostMapping("/complex")
    public void sendObjectMesage(@RequestBody DataModel model) {
        kafkaProducer.sendObject(model);
    }
    ```
    </li>

  </ol>

  Inicia el servidor y envía una petición POST.

</details>
