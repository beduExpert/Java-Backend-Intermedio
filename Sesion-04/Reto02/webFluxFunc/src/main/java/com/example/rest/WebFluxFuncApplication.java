package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WebFluxFuncApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxFuncApplication.class, args);
	}
	
	@Bean
	RouterFunction<ServerResponse> getNumeros() {
		Flux<Integer> flux = Flux.range(1,10).delayElements(Duration.ofSeconds(1)).filter(n -> n % 2 == 0).map(n -> n*2);
	  return route(GET("/numeros").and(accept(MediaType.TEXT_EVENT_STREAM)), req -> ok().body(flux, Integer.class));
	}

}
