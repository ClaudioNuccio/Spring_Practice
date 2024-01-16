package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("v2/")
public class jsonController {
@GetMapping (path = "ciao/{location}")
    public User userJson (
            @PathVariable String location,
            @RequestParam String nome)
{
    return new User(nome,location);
}
   }

