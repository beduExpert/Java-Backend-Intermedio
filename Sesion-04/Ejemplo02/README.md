## Ejemplo 2: Usar functional Enpoints de Spring WebFlux

### Objetivos
* Usar functional Enpoints de Spring WebFlux

### Prerequisitos
* Maven
* JDK 11
* Curl

### Procedimiento

1. Crear un proyecto de spring boot con la dependencia de spring webflux
2. En la clase principal colocar el siguiente bean:
```java
    @Bean
	RouterFunction<ServerResponse> getNumeros() {
		Flux<Integer> flux = Flux.range(1,10).delayElements(Duration.ofSeconds(1)).filter(n -> n % 2 == 0).map(n -> n*2);
	  return route(GET("/numeros").and(accept(MediaType.TEXT_EVENT_STREAM)), req -> ok().body(flux, Integer.class));
	}
```
3. Abrimos una consola y ejecutamos con Curl la URL

    http://localhost:8080/numeros
