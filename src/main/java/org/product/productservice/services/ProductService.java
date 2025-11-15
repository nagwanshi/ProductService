package org.product.productservice.services;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id);
    public List<GenericProductDto> getAllProducts();
    public void updateProductById(Long id);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public boolean deleteProductById(Long id);
}
