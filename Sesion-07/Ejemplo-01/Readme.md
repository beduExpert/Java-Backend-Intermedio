## Ejemplo 01: Spring DevTools

### Objetivo
- Conocer algunas funcionalidades de Spring Dev Tools
- Reducir el tiempo en desarrollo (en la compilación, recarga de aplicación, etc)

### Requisitos
- JDK 8+
- Maven

### Desarrollo
1. Crea un proyecto con spring initializr que contenga las siguientes dependencias:
- - Lombok
- - Spring Dev Tools
- - Spring Web

2. Inicia la aplicación

3. Crea un paquete de controladores `controllers` dentro del paquete principal y dentro de este agrega el siguiente controlador básico:

```java
package org.bedu.ejemplo01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class HelloController {

	@GetMapping(value = "hello-world")
	public Message sayHelloWorld() {
		return new Message("Hola mundo!!!");
	}

	@Data
	@AllArgsConstructor
	private class Message {
		private String message;
	}
}

```
Notas: 
- Recordar que la anotación `RestController` hace que se retornen respuestas en formato JSON de las entidades POJO por defecto.

4. Guarda cambios y comprueba que la aplicación se ha reiniciado automáticamente.

5. Descarga la extensión livereload para su navegador aquí: http://livereload.com/extensions/

6. Establezca que la extensión puede tener acceso a la url del archivo, al localhost, o a todos los sitios (varía según el navegador).

7. Recargue la página en el navegador una última vez y posteriormente haga click en la extensión (Si se muestran las peticiones de red en la consola del navegador se mostrará que se hizo una petición a un archivo js. Este archivo es el que permite la recarga automática en vivo).

8. Haga algún cambio en el proyecto y observe los cambios en el navegador automáticamente.
