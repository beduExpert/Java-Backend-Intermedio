# Nos basamos en la ultima versión de openjdk
FROM openjdk:oracle

# Copiamos el archivo jar al contenedor
COPY target/ejemplo-jar.jar ejemplo-jar.jar

# Exponemos el puerto del contenedor para aceptar conexiones
EXPOSE 8080

# Iniciamos la aplicación
CMD ["java", "-jar", "ejemplo-jar.jar"]