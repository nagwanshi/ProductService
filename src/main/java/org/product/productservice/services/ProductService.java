package org.product.productservice.services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    public String getProductById(  Long id);
    public void getAllProducts(Long id);
    public void updateProductById(Long id);
    public void createProduct();
    public void deleteProductById(Long id);
}
