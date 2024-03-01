package com.example.deploy_env2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class HelloController {
    @Value("${welcomeMsg}")
    String welcomeMsg;
    @GetMapping(path = "/hello")
    public String welcome (){
        return welcomeMsg;
    }

}
