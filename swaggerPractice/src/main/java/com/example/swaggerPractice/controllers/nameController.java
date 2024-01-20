package com.example.swaggerPractice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
public class nameController {
    @GetMapping(path = "Name")
    public String getName(@RequestParam String name) {
        return name;
    }

    @PostMapping(path = "Name")
    public String postName(@RequestParam String name) {
        return name;
    }
}
