package org.product.productservice.controllers;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController( @Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
//        Call FakeStoreProductService getProductByIdMethod

            return productService.getProductById(id);


    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return  productService.getAllProducts();
    }

//    @PatchMapping("/{id}")
    public void updateProductById(int id){ }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById( @PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }
}
