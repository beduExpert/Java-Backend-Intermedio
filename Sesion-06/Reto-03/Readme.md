## Reto 3

### Objetivos
* Recibir un mensaje y deserializarlo a una clase propia.

Srping Kafka nos permite implementar un deserializador personalizado. Este debe convertir un arreglo de bytes a un objeto.

Si se opta por esta opción se debe registrar el valor _spring.kafka.condumer.value-deserializer_ con el deserializador.

Sin embargo esto nos limita a enviar ese único tipo de dato. 

En este ejercicio optaremos por otra opción.

Usa la clase ObjectMapper de Jackson para deserializar un objeto en formato JSON recibido como texto.

<details>
  <summary>Solución</summary>

  <ol>
      <li>Crea una clase POJO para el ejercicio (los atributos deben coincidir con los del Reto 2, ya que lo usaremos como productor).
        ```java
       @Data
       public class MessageModel implements Serializable {
           private String nombre;
           private Short edad;
       } 
        ```
      </li>
      <li>En la clase ModelListener modifica el método de la siguiente manera
    ```java
    @KafkaListener(topics = {"bedu-msg"})
    public void methodListener(String message) {

        try {
            MessageModel messageModel = objectMapper.readerFor(MessageModel.class).readValue(message);
            log.debug("Mensaje Recibido :: {}", messageModel);
        } catch (JsonProcessingException e) {
            log.error("No se pudo instanciar a partir de:: {}", message);
        }

    }


    ```
    donde objectMapper es una instancia de ObjectMapper.
      </li>

  </ol>

  Inicia el servidor y envía una petición POST a la url definida en el reto anterior.

</details>
