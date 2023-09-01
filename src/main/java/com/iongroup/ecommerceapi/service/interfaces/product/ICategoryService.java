package com.iongroup.ecommerceapi.service.interfaces.product;

import com.iongroup.ecommerceapi.entity.product.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    List<Category> findAll();
    void save(Category category);
    void update(Category category, Category updatedCategory);
    void delete(Long id);
}
