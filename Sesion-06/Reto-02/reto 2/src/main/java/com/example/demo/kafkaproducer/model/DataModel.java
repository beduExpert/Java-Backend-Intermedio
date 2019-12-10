package com.example.demo.kafkaproducer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataModel implements Serializable {
    private String nombre;
    private Short edad;
}
