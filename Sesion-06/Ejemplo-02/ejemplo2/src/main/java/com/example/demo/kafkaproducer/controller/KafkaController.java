package com.example.demo.kafkaproducer.controller;


import com.example.demo.kafkaproducer.model.DataModel;
import com.example.demo.kafkaproducer.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("")
    public void sendMessage(@RequestParam("msg") String message) {
        kafkaProducer.sendMessage(message);
    }

}
