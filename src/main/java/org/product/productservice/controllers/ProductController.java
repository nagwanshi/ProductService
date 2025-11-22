package org.product.productservice.controllers;

import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.exceptions.ProductNotFoundException;
import org.product.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(  ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
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
    public GenericProductDto deleteProductById( @PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        ResponseEntity responseEntity = new ResponseEntity(exceptionDto, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
