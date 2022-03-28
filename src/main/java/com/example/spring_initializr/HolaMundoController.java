package com.example.spring_initializr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @RequestMapping("/esp")
    public String index() {
        return "Hola a todo el mundo!";
    }

    @RequestMapping("/swe")
    public String indexSvenska() {
        return "Hejsan världen!";
    }
}
