package com.example.deploy_2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class numberController {

    @GetMapping(path = "/sum")
    public int getRandomSum (){
        int firstNumber = (int) (Math.random()*100);
        int secondNUmber = (int) (Math.random()*100);
        return firstNumber + secondNUmber;
    }
}
