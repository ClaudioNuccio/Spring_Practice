package com.example.lezioneHibernate.controllers;

import com.example.lezioneHibernate.entities.Product;
import com.example.lezioneHibernate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ProductController {
@Autowired ProductRepository productRepository;
    @PostMapping(path ="/create" )
    private Product createProduct (@RequestBody Product product){
       return productRepository.saveAndFlush(product);
    }
}
