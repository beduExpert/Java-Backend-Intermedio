## Reto 3: Despliegue en un contenedor Docker

### Objetivo
1. Desplegar una aplicación Spring Boot mediante un contenedor de Docker

### Requisitos previos
- El JAR generado durante el Ejemplo 1
- Docker

### Desarrollo 
1. Una vez que tengamos nuestro archivo jar listo, entraremos a la carpeta raíz de nuestro proyecto.
2. Crearemos un archivo llamado _Dockerfile_ donde definiremos los pasos necesarios para crear la imagen de nuestra aplicación:
```
# Nos basamos en la ultima versión de openjdk
FROM openjdk:oracle

# Copiamos el archivo jar al contenedor
COPY target/ejemplo-jar.jar ejemplo-jar.jar

# Exponemos el puerto del contenedor para aceptar conexiones
EXPOSE 8080

# Iniciamos la aplicación
CMD ["java", "-jar", "ejemplo-jar.jar"]
```
3. Ejecutaremos el siguiente comando para generar la imagen de nuestra aplicación: `docker image build -t ejemplo-docker:latest .`, donde el parámetro -t especifica el nombre y etiqueta de la imagen que creamos.
4. Una vez que se haya terminado de generar la imagen, crearemos un contenedor nuevo y lo ejecutaremos mediante el siguiente comando: `docker container run -p 8080:8080 -d --name contenedor-jar ejemplo-docker`, donde -p publica los puertos de nuestro contenedor, -d ejecuta el contenedor en segundo plano y --name define el nombre de nuestro contenedor.
5. Finalmente, podemos probar nuestra aplicación accediendo a localhost:8080.
