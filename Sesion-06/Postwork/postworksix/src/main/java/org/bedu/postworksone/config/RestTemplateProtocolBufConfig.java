package org.bedu.postworksone.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateProtocolBufConfig {
	
	@Bean
	public RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
	    return new RestTemplate(Arrays.asList(hmc));
	}
}
