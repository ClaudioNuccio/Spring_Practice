package com.example.interceptor_2.controllers;

import com.example.interceptor_2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonth(HttpServletRequest request) {

        Month month = (Month) request.getAttribute("month");
        if(month!=null) {
            return month;
        } else {
            return new Month(null,"nope","nope","nope");
        }
    }
}