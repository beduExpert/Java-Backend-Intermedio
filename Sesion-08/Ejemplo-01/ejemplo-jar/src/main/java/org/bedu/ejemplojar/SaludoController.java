package org.bedu.ejemplojar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @RequestMapping("")
    public String hola(){
        return "Hola mundo desde un JAR";
    }
}
