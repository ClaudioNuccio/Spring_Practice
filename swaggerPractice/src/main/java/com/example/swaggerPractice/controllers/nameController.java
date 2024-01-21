package com.example.swaggerPractice.controllers;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Practice", description = "A practice controller to write with Swagger following OpenAPI standards")
@RestController
@RequestMapping("v1/")
public class nameController {
    @GetMapping(path = "Name")
    public String getName(@RequestParam String name) {
        return name;
    }

    @PostMapping(path = "Name")
    public StringBuilder postName(@RequestParam String name) {
        StringBuilder invertedName = new StringBuilder(name);
        return  invertedName.reverse();
    }
}
