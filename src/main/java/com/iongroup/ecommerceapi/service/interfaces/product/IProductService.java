package com.iongroup.ecommerceapi.service.interfaces.product;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public abstract Optional<Product> findById(Long id);
    public abstract List<Product> findAll();
    public abstract void save(Product product);
    public abstract void update(Product product, Category updatedProduct);
    public abstract void delete(Long id);
}
