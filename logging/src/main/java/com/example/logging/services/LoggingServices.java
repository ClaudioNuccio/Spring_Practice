package com.example.logging.services;

import com.example.logging.exceptions.MyCustomException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class LoggingServices {

    Logger logger = (Logger) LoggerFactory.getLogger(LoggingServices.class);

    @Value("${custom.int1:2}")
    private int customInt1;

    @Value("${custom.int2:8}")
    private int customInt2;

    public String welcome() {
        logger.info("Welcome to the application!");
        return "Welcome";
    }

    public double exponent() {
        logger.debug("Starting exponent calculation");
        double result = Math.pow(customInt1, customInt2);
        logger.debug("Exponent calculation finished, result: {}", result);
        return result;
    }

    public String errors() {
        throw new MyCustomException("This is a custom error!");
    }
}