package org.product.productservice.services;

import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    @Override
    public String getProductById(Long id) {
        return "Product with id: " + id;
    }

    @Override
    public void getAllProducts(Long id) {

    }

    @Override
    public void updateProductById(Long id) {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void deleteProductById(Long id) {

    }
}
