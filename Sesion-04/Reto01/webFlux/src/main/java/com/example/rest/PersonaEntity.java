package com.example.rest;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PersonaEntity {
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;

    private final String telefono;
}
