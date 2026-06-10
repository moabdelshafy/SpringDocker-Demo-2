package com.demo.staticapi.controller;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.demo.staticapi.model.Product;

class ProductControllerTest {

    private final ProductController controller = new ProductController();

    @Test
    void shouldReturnStaticProducts() {
        List<Product> products = controller.getProducts();

        assertThat(products)
                .hasSize(4)
                .extracting(Product::name)
                .containsExactly("Laptop", "Keyboard", "Monitor","Mouse");
    }
}
