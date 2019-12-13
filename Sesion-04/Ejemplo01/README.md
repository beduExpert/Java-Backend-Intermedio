## Ejemplo 1: Crear un proyecto con Spring WebFlux

### Objetivos
* Hacer un Endpont de tipo WebFlux

### Prerequisitos
* Maven
* JDK 11
* Curl

### Procedimiento

1. Crear un proyecto de spring boot con la dependencia de spring webflux
2. Crea una clase llamada  `Subscriber` con el siguiente metodo estatico:
```java
    public static void multiplicar(Integer n)  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Subscriber2: "+n*n);
    }
```
3. Crea una clase llamada  `NumerosController` con el siguiente codigo:

```java
    @RestController
    public class NumerosController {

        @GetMapping(path = "/numeros", produces = "text/event-stream")
        public Flux<Integer> all () {
            Flux<Integer> flux = Flux.range(1,30)
                    .delayElements(Duration.ofSeconds(1))
                    .filter(n -> n % 2 == 0) // solo números divisibles entre 2
                    .map(n -> n*2);

            flux.subscribe(System.out::println); // suscriptor 1
            flux.subscribe(Subscriber::multiplicar); // suscriptor 2
            return flux; // retornamos el elemento. Sería como el suscriptor 3
        }
    }
```

3. Abrimos una consola y ejecutamos con Curl la URL

    http://localhost:8080/numeros

NOTA:  No ocupamos Postman ya que es un cliente bloqueante y nos devolvera la respuesta hasta que termine el Observable.





