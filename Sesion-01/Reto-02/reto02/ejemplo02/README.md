## Ejemplo 2: 

### Objetivo
- Conectar una base de datos Mongo con Spring
- Comprender la persistencia en Mongo desde Spring
- Reafirmar conceptos de MongoDB desde Spring

### Requisitos
- MongoDB instalado
- JDK 8 o superior
- IDE de tu preferencia
- mongodb compass (Recomendado pero no necesario)

### Desarrollo
1. Se crea un proyecto Java con JDK 8 o superior.
2. Se crea una Clase llamada `User` y se agrega la anotación `@Document(collection = "users")` (Esta anotación especifica que la clase será mapeada a un documento en Mongo, `collection = "users"` especifica el nombre del documento en caso que no se desee usar el nombre de la clase).
3. Se agregan los atributos de la clase. El único atributo especial es `id`. Este debe ser de tipo String (corresponde al campo `ObjectId`) y debe ser anotado con `@Id` (De esta manera se especifica que esta propiedad será usada como identificador del documento).
4. Para reducir codigo se utilizará la librería Lombok y las siguientes anotaciones :
- `@AllArgsConstructor`: Crea Un constructor con todos los atributos (excepto los finales)
- `@NoArgsConstructor`: Crera un constructor sin atributos (vacío)
- `@Data`: Crea los `getters` y `setters` comunes en java además de sobre-escribir el método `equals` y `hashCode` de una manera común (para más info: https://projectlombok.org/features/all).

El código quedaría de la siguiente manera:

```java
package org.bedu.ejemplo02.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;

    private String username;
    private String email;
    private String Password;
    private Date createdAt;
    private Date updatedAt;
}
```
5. Ahora, se creará el repositorio con el que se manejará la persistencia y las operaciones en BD de la entidad anterior:
```java
package org.bedu.ejemplo02.Repositories;

import org.bedu.ejemplo02.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
```
Como se muestra, el código es realmente sencillo gracias a la interfáz `CrudRepository` de la cuál se heredan las operaciones básicas de un CRUD.

6. Se Agrega la configuración en el archivo `application.properties` necesaria para establecer la conexión a la BD Mongo:
```
spring.data.mongodb.uri=mongodb://localhost:27017/ejemplo_dos
```
7. Para observar la persistencia en mongo desde Spring, se crearán algunos registros con el repositorio `UserRepository`, esto se puede hacer de varias maneras, pero quizá la manera más rápida es utilizando la clase la clase marcada como principal y la interfáz `CommandLineRunner`. Esta interfaz define un método llamado `run` que se ejecutará justo cuando inicia la aplicación y toma los parámetros de entrada del método main para realizar algo; Aunque en este caso, usaremos este método para borrar un documento y crear un registro en la base de datos de la siguiente manera:

```java
package org.bedu.ejemplo02;

import org.bedu.ejemplo02.Repositories.UserRepository;
import org.bedu.ejemplo02.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
public class Ejemplo02Application implements CommandLineRunner {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ejemplo02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection("users");

        User user = new User(null, "rosaHdez", " rosa.hdez@email.com", "nosegura", new Date(), new Date());
        user = userRepository.save(user);
        log.info(user.toString());
    }
}
```
Notas:
- Recordar que "users" es el nombre del documento (este se definió en la clase User).
- `MongoTemplate` es una clase que define métodos muy útiles a nivel de base de datos. En este caso, como se muestra en la clase, se utilizó para eliminar el documento cada que la aplicación inicie (para consultar esta interfáz: https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/MongoTemplate.html).

Si se ejecuta la aplicación, y se hace examina la BD (se recomienda mongodb compass) se notará que ahora se tiene una base de datos llamada "ejemplo_dos" (ya que este nombre se definió en el archivo `application.properties`) y de igual manera un documento llamado "users" (que es el que se creó con el repositorio).