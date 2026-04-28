package br.com.fiap.caloriescounter.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/english")
    public String getSayHello() {
        return "Hello World!";
    }

    @GetMapping("/deutsch")
    public String getSagHallo() {
        return "Servus zusammen!";
    }
}
