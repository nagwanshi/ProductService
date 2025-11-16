package org.product.productservice.thirdPartyClients;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyClient {
    public FakeStoreProductDto getProductById (Long id) throws ProductNotFoundException;
    public List<FakeStoreProductDto> getAllProducts();
    public void updateProductById(Long id);
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto);
    public FakeStoreProductDto deleteProductById(Long id) throws ProductNotFoundException;
}
