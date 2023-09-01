package com.iongroup.ecommerceapi.service.interfaces.product;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product) throws InterruptedException;
    void update(Product product, Category updatedProduct);
    void delete(Long id);
}
