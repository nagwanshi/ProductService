package org.product.productservice.controllers;


import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.product.productservice.controllers.ProductController;
import org.product.productservice.exceptions.ProductNotFoundException;
import org.product.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockitoBean
    ProductService productService;


    @Test
    public void testProductByIdMocking() throws ProductNotFoundException {
        when(productService.getProductById(any(Long.class))).thenReturn(null);
        assertNull(productController.getProductById(100L));
    }
}
