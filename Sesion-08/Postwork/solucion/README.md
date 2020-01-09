## Respuesta al postwork de la sesión 8

- ¿Qué tipo de despliegue requerirá el proyecto?
```
Se requiere generar un archivo jar, mediante el cual se creará una imagen de Docker que contendrá nuestra aplicación y será desplegada en un contenedor nuevo.
```
- ¿Qué pasos deben llevarse a cabo para desplegar correctamente la aplicación en la infraestructura del hospital?

1. Mediante el comando `mvn clean package` compilaremos nuestro proyecto, que será empaquetado en un JAR ubicado en la carpeta _target_
2. Crearemos una nueva imagen de Docker, copiando nuestro archivo jar a una carpeta nueva y creando en la misma un archivo llamado _Dockerfile_ con la siguiente estructura:
```
FROM openjdk:oracle
COPY {nombre_del_jar}.jar {nombre_del_jar}.jar
EXPOSE 8080
CMD ["java", "-jar", "{nombre_del_jar}.jar"]
```
3. Mediante el comando `docker image build -t {nombre-imagen}:latest .` crearemos la imagen de nuestra aplicación.
4. Empleando el comando `docker container run -p 8080:8080 -d --name {nombre-contenedor} {nombre-imagen}` ejecutaremos nuestra aplicación, que estará disponible en el puerto 8080.
5. Finalmente probaremos el funcionamiento de nuestra aplicación.