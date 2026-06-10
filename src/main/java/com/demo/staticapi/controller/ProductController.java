package com.demo.staticapi.controller;

import com.demo.staticapi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "Laptop"),
                new Product(2L, "Keyboard"),
                new Product(3L, "Monitor")
        );
    }
}
