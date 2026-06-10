package com.demo.staticapi.controller;

import com.demo.staticapi.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductControllerTest {

    private final ProductController controller = new ProductController();

    @Test
    void shouldReturnStaticProducts() {
        List<Product> products = controller.getProducts();

        assertThat(products)
                .hasSize(3)
                .extracting(Product::name)
                .containsExactly("Laptop", "Keyboard", "Monitor");
    }
}
