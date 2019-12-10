## Ejemplo 3: Despliegue detrás de NGINX

### Objetivo
1. Desplegar una aplicación Spring Boot detrás de un proxy inverso de NGINX

### Requisitos previos
- El JAR generado durante el Ejemplo 1
- NGINX en Linux

### Desarrollo 
En este ejemplo realizaremos unicamente el despliegue de nuestra aplicación, sin configurarla para que se inicie como servicio al inicio del sistema.
1. Nos aseguraremos de que nuestra aplicación esté ejecutándose (`java -jar ejemplo-jar.jar`)

2. Editaremos el archivo `/etc/ngnix/sites-available/default`, buscaremos la sección location y la reemplazaremos con lo siguiente:
```
location /ejemplo {
  proxy_pass http://localhost:8080;
}
```
3. De esta manera, todas las solicitudes que entren a http://localhost/ejemplo serán dirigidas a http://localhost:8080 , podemos probar accediendo a la dirección desde un navegador y comprobando que recibimos el saludo desde nuestra aplicación web.
