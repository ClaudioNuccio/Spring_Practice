package com.example.logging.controllers;

import com.example.logging.services.LoggingServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    @Autowired
    LoggingServices loggingServices;

    @GetMapping("/")
    public String welcome() {
        return loggingServices.welcome();
    }

    @GetMapping("/exp")
    public double calculateExponent() {
        return loggingServices.exponent();
    }

    @GetMapping("/get-errors")
    public String getErrors() {
        return loggingServices.errors();
    }
}