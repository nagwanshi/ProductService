package org.product.productservice.services;

import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.controllers.ProductController;
import org.product.productservice.exceptions.ProductNotFoundException;
import org.product.productservice.models.Product;
import org.product.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
       Product product =  productRepository.getReferenceById(UUID.fromString("34773130-246c-427c-b3b8-c8ca8856d7f1"));

       GenericProductDto genericProductDto = new GenericProductDto();
       genericProductDto.setId(product.getId());
       genericProductDto.setImage(product.getImage());
       genericProductDto.setDescription(product.getDescription());

       return genericProductDto;

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public void updateProductById(Long id) {

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws ProductNotFoundException {
        return null;
    }
}
