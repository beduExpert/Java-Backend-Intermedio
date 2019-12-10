package com.example.demo.kafkaproducer.kafka.listener;

import com.example.demo.kafkaproducer.model.MessageModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ModelListener {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"bedu-msg"})
    public void methodListener(String message) {

        try {
            MessageModel messageModel = objectMapper.readerFor(MessageModel.class).readValue(message);
            log.debug("Mensaje Recibido :: {}", messageModel);
        } catch (JsonProcessingException e) {
            log.error("No se pudo instanciar a partir de:: {}", message);
        }

    }


}
