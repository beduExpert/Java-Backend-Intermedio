package com.example.demo.kafkaproducer.service;

import com.example.demo.kafkaproducer.model.DataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaProducer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("bedu-msg", message).completable();
    }

    @SneakyThrows
    public void sendObject(DataModel object) {
        sendMessage(mapper.writeValueAsString(object));
    }

}
