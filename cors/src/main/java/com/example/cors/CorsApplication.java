package com.example.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/v1/getname").allowedOrigins("http://localhost:8080");
				registry.addMapping("/v1/createreversedname").allowedOrigins("http://localhost:8080");
			}
		};
	}
}

