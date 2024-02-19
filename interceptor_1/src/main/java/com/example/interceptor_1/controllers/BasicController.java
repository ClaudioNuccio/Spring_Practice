package com.example.interceptor_1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


@RestController
@RequestMapping("")
public class BasicController {
    @GetMapping("/time")
    public OffsetDateTime getCurrentDataTime() {
        return OffsetDateTime.now();
    }
}