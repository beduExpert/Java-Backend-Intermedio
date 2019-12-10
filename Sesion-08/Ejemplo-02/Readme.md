## Ejemplo 2: Instalando Apache Tomcat

### Objetivo
1. Instalar el servidor Apache Tomcat para poder desplegar aplicaciones web

### Requisitos previos
- Java SE

### Desarrollo 
1. Accederemos a la página principal de [Apache Tomcat](https://tomcat.apache.org/) y descargaremos la ultima versión disponible.

2. Extraeremos el contenido del zip dentro de una carpeta llamada _tomcat_

3. Abriremos una terminal o consola y nos dirigiremos a la carpeta bin dentro del contenido que extrajimos.

4. Mediante el comando `catalina.sh run` en Linux o `catalina.bat run` en Windows iniciaremos la ejecución del servidor Tomcat.

5. Finalmente, probaremos que funcione correctamente accediendo mendiante nuestro navegador a _localhost:8080_ y comprobando que podemos ver la página de bienvenida de Tomcat.
