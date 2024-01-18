package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/")
public class jsonController {
    @GetMapping(path = "ciao/{location}")
    public User userJson(@PathVariable String location, @RequestParam String nome) {
        return new User(nome, location);
    }

    @GetMapping(path = "getNome/{id}")
    public static String getNome(@PathVariable Integer id) {
        User user1 = new User("Giacomo", "Busto Arsizio");
        return user1.getNome();
    }

    @GetMapping(path = "sum")
    public Integer sum(
            @RequestParam String value1,
            @RequestParam String value2,
            @RequestParam String value3
    ) {
        int v1 = 0;
        if (!value1.isEmpty()) {
            v1 = Integer.parseInt(value1);
        }

        if (!value1.isEmpty() && !value2.isEmpty() && !value3.isEmpty()) {
            return Integer.parseInt(value1) +
                    Integer.parseInt(value2) +
                    Integer.parseInt(value3);
        } else {
            return 0;
        }
    }
}




