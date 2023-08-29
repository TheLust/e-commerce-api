package com.iongroup.ecommerceapi.service.interfaces.product;

import com.iongroup.ecommerceapi.entity.product.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public abstract Optional<Category> findById(Long id);
    public abstract Optional<Category> findByName(String name);
    public abstract List<Category> findAll();
    public abstract void save(Category category);
    public abstract void update(Category category, Category updatedCategory);
    public abstract void delete(Long id);
}
