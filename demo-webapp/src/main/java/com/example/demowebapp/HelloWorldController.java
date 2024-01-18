package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("v1/")
public class HelloWorldController {
    @GetMapping(path = "helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "ciao")
    public String ciaoUser(@RequestParam String nome,
                           @RequestParam String location) {
        return "Ciao " + nome + " com'è il tempo in " + location + "?";
    }
}