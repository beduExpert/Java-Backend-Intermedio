## Ejemplo 2: Spring Boot Actuator

### Objetivos
- Probar algunas características de Spring Boot Actuator.
- Comprobar características de nuestra aplicación gracias a esta herramienta.
- Comprender la ventaja de conocer los datos de monitoreo que se presentan con el tiempo y lo benéfico que puede ser para el negocio.


### Requisitos
- JDK 8+
- Maven
- Lombok
- Spring Dev Tools
- Spring Web
- Si se usa navgador Chrome se recomienda (Pero no necesario) la extensión [JSON Viewer](https://chrome.google.com/webstore/detail/json-viewer/gbmdgpbipfallnflgajpaliibnhdgobh) para una navefación y formateo más sencillo en formatos JSON.
### Desarrollo
1. Continuaremos desde el proyecto 1 y agregaremos la dependencia de actuator:

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

2. Inicia la aplicación

3. Verificar la respuesta del siguiente endpoint: servidor:puerto`/actuator/health`
- - por ejemplo: `http://localhost:8080/actuator/health`

Si todo va bien se debería mostrar una respuesta JSON como la siguiente:

```json
{
  "status": "UP"
}
```

4. Agregar en el archivo de configuración (properties/yaml) la siguiente línea:

```
management.endpoint.health.show-details=always
```
Esta línea de código lo que hace es permitir mostrar información a cualquier petición sin necesidad de requerir autorización.

Si se verifica el navegador nuevamente (recordar que no es necesario reiniciar la aplicación ni refrescar el navegador gracias a dev tools) ahora se mostrará una respuesta json un poco más amplia:

```json
{
  "status": "UP",
  "components": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 151655858176,
        "free": 77001412608,
        "threshold": 10485760
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

Como se muestra, la información puede ser bastante útil con el paso del tiempo.

Al igual que el endpoint `/health` hay una [amplia lista](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints) de endpoints para analizar, sin embargo por defecto solo están habilitados `health` e `info`.

5. Ir a endpoint `/actuator` en el navegador:
- - `http://localhost:8080/actuator`

Para habilitar otros endpoints podemos hacer uso de:

```
management.endpoints.web.exposure.include=env,mapping
```

Si se observa el navegador la lista ha cambiado,

La línea anterior entonces, habilita la información de estos endpoints, si se analizan se mostrará información de bastante importante, sobre todo en caso de que algo ande mal en producción.

Para habilitar todos los enpoints se puede utilizar un `*` en lugar de los endpoints:

```
management.endpoints.web.exposure.include=*
```

El endpoint bean se habilita:

```
management.endpoint.beans.enabled=true
```

Observe el navegador.

En ocaciones esta información puede ser útil en otros dominios (por ejemplo usando microservicios).
Por lo cuál para habilitar el [intercambio de recursos de origen cruzado](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) se puede utilizar las siguientes líneas de código en la configuración:

```
# management.endpoints.web.cors.allowed-origins=*
# management.endpoints.web.cors.allowed-methods=GET,POST
```

En estas líneas pueden ir las direcciones ip/ dominios a los cuales se les permitirá el acceso a la información (por defecto a ninguno) así como qué métodos HTTP podrán utilizar (por defecto solo GET) respectivamente.
