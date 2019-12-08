## Ejemplo 01: Usar Spring boot para crear un microservicio

### Objetivos
* Familiarizarnos con spring boot

### Prerequisitos
* Maven
* JDK 11
* Postman

### Procedimiento

1. Crea el proyecto demo con la dependencia de spring web
2. Crear un paquete llamado "entity" el cual contenga la clase "Auto" con el siguiente codigo:
```java
    @Data
    public class Auto {
        private int id;
        private String modelo;
        private String color;
        private String marca;
    }
```
3. Crear un paquete llamado "controller" el cual contenga la clase "DemoController" con el siguiente codigo:
```java
    @RestController
    @RequestMapping("/micro")
    @Slf4j
    public class DemoController {
    
        @PostMapping("/auto")
        public void recibe(@RequestBody Auto auto){
            log.info(auto.toString());
        }
    }
```

4. Una vez terminado lo ejecutamos y abrimos postman y colocamos la informacion como se ve en la imagen:

    ![Postman](../img/post.PNG)


5. Damos click en Send y se mostrara en consola la informacion que enviamos






