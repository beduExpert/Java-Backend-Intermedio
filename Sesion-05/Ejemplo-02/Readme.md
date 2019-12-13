## Ejemplo 2: Archivos .proto para la serialización en Protocol Buffers

### Objetivo
- Conocer los archivos .proto para la serialización en Protocol Buffers
- Relacionarse y conocer las características y funcionalidades de los archivos .proto
---

### Requisitos
- JDK 8 (o superior)
---

### Desarrollo

1. Crear un proyecto `ejemplo02` con dependencia spring web y lombok.

2. Crear un paquete `protos` sobre el paquete principal.

3. Agregar la siguiente dependencia de protocol buffers en el pom.xml:

```
<dependency>
  <groupId>com.google.protobuf</groupId>
  <artifactId>protobuf-java</artifactId>
  <version>3.11.1</version>
</dependency>
```
4. Crear un archivo proto `login.proto` dentro del paquete `protos` con la siguiente estructura:

```
syntax = "proto2";

package org.bedu.ejemplo01.protos;

option java_package = "org.bedu.ejemplo02.protos.models";
option java_outer_classname = "LoginProto";

message User {
  required int32 id = 1;
  required string name = 2;
  required string email = 3;
  required string password = 4;
}

enum Gender {
    MALE = 0;
    FEMALE = 1;
  }

message Student {
    required int32 id = 1;
    required User user = 2;
    required int32 age = 3;
    required float stature = 4;
    optional bool certified = 5;
    required Gender gender = 6;
}
```

5. Compilar el archivo `login.proto` del proyecto 1 (ruta: `05 Protocol Buffers\ejemplo02\src\main\java\org\bedu\ejemplo02\protos\login.proto`):

```bash
protoc --java_out="PATH\05 Protocol Buffers\ejemplo02\src\main\java" --proto_path="PATH\05 Protocol Buffers\ejemplo02\src\main\java" 'PATH\05 Protocol Buffers\ejemplo02\src\main\java\org\bedu\ejemplo02\protos\login.proto'
```

Esto debería crear el paquete models dentro de protos. Con nuestra clase compilada.

6. Crear una clase de configuración ProtoBufCondig en el paquete `protos.condif`:

```java
package org.bedu.ejemplo02.protos.config;

import java.util.HashMap;
import java.util.Map;

import org.bedu.ejemplo02.protos.models.LoginProto;
import org.bedu.ejemplo02.protos.models.LoginProto.User;
import org.bedu.ejemplo02.protos.repository.VirtualUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtobufConfig {
	
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	private LoginProto.User newUser(int id, String nombre, String email, String password) {

		return LoginProto.User.newBuilder()
			.setId(id)
			.setName(nombre)
			.setEmail(email)
			.setPassword(password)
		.build();
	}

	@Bean
	public VirtualUserRepository createUsers() {
		Map<Integer, User> users = new HashMap<>();
		
		User user = newUser(1, "Hernan", "hernan.123@mail.com", "nosegura");
		users.put(user.getId(), user);
		
		user = newUser(2, "Mary", "mary.ros@email.com", "pass");
		users.put(user.getId(), user);
		
		user = newUser(3, "Jose", "jos.091@email.com", "contras23");
		users.put(user.getId(), user);
		
		return new VirtualUserRepository(users);
	}
}

```

7. Crear una clase `VirtualUserRepository` que fungirá como repositorio en el paquete `protos.repository`:

```java
package org.bedu.ejemplo02.protos.repository;

import java.util.Map;

import org.bedu.ejemplo02.protos.models.LoginProto.User;

public class VirtualUserRepository {
	private Map<Integer, User> users;

	public VirtualUserRepository(Map<Integer, User> users) {
		this.users = users;
	}

	public User getUser(int id) {
		return users.get(id);
	}
}

```

8. Crear un controlador `UserController` en el paquete `protos.controllers`:

```java
package org.bedu.ejemplo02.protos.controllers;

import org.bedu.ejemplo02.protos.models.LoginProto;
import org.bedu.ejemplo02.protos.repository.VirtualUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private VirtualUserRepository userRepository;

	@RequestMapping("/user/{id}")
	LoginProto.User user(@PathVariable Integer id) {
		return this.userRepository.getUser(id);
	}
}
```

9. Ejecutar la aplicación, si todo está correcto debería ejecutarse sin problemas.

10. (Opcional) si se tiene postman CURL o desde el navegador (descargar archivo serializado), se puede hacer la petición a la url del controlador:
`http://localhost:8080/user/1` y observar la respuesta (Debería estar serializada):

```
Marymary.ros@email.com"pass
```
