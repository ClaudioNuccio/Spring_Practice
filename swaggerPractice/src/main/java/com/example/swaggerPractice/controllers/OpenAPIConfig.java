package com.example.swaggerPractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
//Add urls in application.properties
@Configuration
public class OpenAPIConfig {

    @Value("${swaggerPractice.openapi.dev-url}")
    private String devUrl;

    @Value("${swaggerPractice.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("nuccio.claudio98@gmail.com");
        contact.setName("Nuccio Claudio");
        contact.setUrl("https://github.com/ClaudioNuccio/ClaudioNuccio");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API return username with get API and reverse it with a  POST")
                .termsOfService("https://it.wikipedia.org/wiki/Licenza_MIT")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }


}