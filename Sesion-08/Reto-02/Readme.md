## Reto 2: Creando un WAR con Spring Boot

### Objetivo
1. Crear un archivo WAR capaz de ser desplegado en un contenedor como Tomcat o Jetty.

### Requisitos previos
- JDK
- Apache Maven
- Apache Tomcat o similar

### Desarrollo 
1. Mediante Spring Initializr crearemos un nuevo proyecto, cambiando el artefacto a _ejemplo-war_ y especificando su empaquetado en _war_
2. Agregaremos también la dependencia de _Spring Web_ y generaremos nuestra aplicación.
3. Extraeremos el zip generado y abriremos el archivo pom.xml, donde cambiaremos el apartado build para omitir el numero de versión en nuestro WAR.
```xml
<build>
	<finalName>${artifactId}</finalName>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```
4. Spring Initializr se encargó de generar la clase ServletInitializer, encargada de especificar la configuración necesaria para generar el archivo web.xml requerido en la estructura de un WAR.
5. Agregaremos la clase SaludoController, cuya implementación será igual a la usada en el Ejemplo 1
```java
@RestController
public class SaludoController {
    @RequestMapping("")
    public String hola(){
        return "Hola mundo desde un WAR";
    }
}
```
6. Construiremos nuestra aplicación mediante `mvn clean package`, con lo que se creará un archivo llamado ejemplo-war.war en la carpeta _target_ 
7. Copiaremos ese archivo a la carpeta _webapps_ dentro de la carpeta donde instalamos nuestro servidor Tomcat y ejecutaremos el servidor con `catalina run`
8. Accederemos a la dirección localhost:8080/ejemplo-war y comprobaremos que recibimos el saludo de nuestra aplicación.
