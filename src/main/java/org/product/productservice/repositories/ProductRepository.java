package org.product.productservice.repositories;

import org.product.productservice.models.Category;
import org.product.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll(); // Get all the products from product table
    List<Product> findAllByName(String name);
    List<Product> findAllByCategory(Category category);
    List<Product>   findAllByNameAndDescription(String name, String desc);
     List<Product> findAllByPrice_PriceGreaterThan(double price);
//    List<Product> findAllByPrice_ValueLessThan(double price);
}
