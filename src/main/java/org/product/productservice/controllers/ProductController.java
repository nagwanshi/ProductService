package org.product.productservice.controllers;

import org.product.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController( @Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById( @PathVariable("id") Long id){
//        Call FakeStoreProductService getProductByIdMethod

            return productService.getProductById(id);


    }

    @GetMapping
    public void getAllProducts(int id){ }

//    @PatchMapping("/{id}")
    public void updateProductById(int id){ }

//    @PostMapping
    public void createProduct(){ }
    @DeleteMapping("/{id}")
    public void deleteProductById(int id){ }
}
