package com.example.deploy_env1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class TestController {
    @Value("${devName}")
    String devName;
    @Value("${authCode}")
    String authCode;

    @GetMapping(path = "/devname")
    public String greeting (){

      return "Hello " + devName;
    }
    @GetMapping(path = "/authcode")
    public String authCode (){
        return "Hello " + authCode;
    }
}
