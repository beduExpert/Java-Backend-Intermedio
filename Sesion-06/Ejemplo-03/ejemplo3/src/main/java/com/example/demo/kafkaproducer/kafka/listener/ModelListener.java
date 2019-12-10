package com.example.demo.kafkaproducer.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ModelListener {

    @KafkaListener(topics = {"bedu-msg"})
    public void methodListener(String message){

       log.debug("Mensaje Recibido :: {}", message);


    }


}
