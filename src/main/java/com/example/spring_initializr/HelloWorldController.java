package com.example.spring_initializr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/list")
    public List<String> hello() {
        return List.of("Hello", "World");
    }

}
