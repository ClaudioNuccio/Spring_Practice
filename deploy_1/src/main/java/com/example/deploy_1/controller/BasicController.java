package com.example.deploy_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class BasicController {
 @Value("${devName}")
 String devName ;

    @GetMapping(path = "/getdevname")
    public String getDevName (){
        return devName;
    }
}
