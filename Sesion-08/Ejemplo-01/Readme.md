## Ejemplo 1: Creando un JAR de Spring Boot

### Objetivo
1. Utilizar spring-boot-maven-plugin para la creación de un jar ejecutable que contenga una aplicación web.
2. Comprobar el funcionamiento de la aplicación web mediante la ejecución del jar.

### Requisitos previos
- JDK
- Apache Maven

### Desarrollo
1. Apoyándonos de Spring Initializr crearemos una aplicación web sencilla que nos retorne un Hello World! al acceder a ella, para ello entraremos al sitio de [Spring Initializr](https://start.spring.io/)
2. Llenaremos los datos necesarios para crear nuestra aplicación, ingresando el grupo (org.bedu) y nombre de nuestro artefacto (ejemplo-jar).
3. Dentro del apartado de opciones revisaremos que el empaquetado esté especificado en jar y dentro de las dependencias agregaremos _Spring Web_ para generar una aplicación Web que incluya un servidor embebido.
4. Crearemos el proyecto mediante el botón _Generate_ o presionando Ctrl + Enter, lo que nos dará un archivo zip para descargar.
5. Agregaremos un controlador sencillo que nos salude al ingresar a nuestra aplicación para verificar su funcionamiento, para ello crearemos una nueva clase llamada SaludoController, cuyo código será el siguiente:
```java
@RestController
public class SaludoController {
    @RequestMapping("")
    public String hola(){
        return "Hola mundo desde un JAR";
    }
}
```
6. En terminal ejecutaremos el comando `mvn clean package` para crear nuestro archivo jar, que se ubicará dentro de la carpeta _target_
7. Finalmente, ejecutaremos `java -jar ejemplo-jar-0.0.1-SNAPSHOT.jar` para levantar el servidor Tomcat embebido y poder probar nuestra aplicación accediendo a _localhost:8080_
