package org.product.productservice.services;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    public GenericProductDto getProductById(Long id);
    public void getAllProducts(Long id);
    public void updateProductById(Long id);
    public void createProduct();
    public void deleteProductById(Long id);
}
