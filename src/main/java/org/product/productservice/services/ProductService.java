package org.product.productservice.services;


import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById (Long id) throws ProductNotFoundException;
    public List<GenericProductDto> getAllProducts();
    public void updateProductById(Long id);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public GenericProductDto deleteProductById(Long id);
}
