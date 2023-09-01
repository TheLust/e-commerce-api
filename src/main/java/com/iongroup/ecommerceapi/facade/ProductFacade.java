package com.iongroup.ecommerceapi.facade;

import com.iongroup.ecommerceapi.dto.product.ProductDto;
import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Product;
import com.iongroup.ecommerceapi.exception.NotFoundException;
import com.iongroup.ecommerceapi.exception.NotSavedException;
import com.iongroup.ecommerceapi.mapper.ProductMapper;
import com.iongroup.ecommerceapi.service.product.CategoryService;
import com.iongroup.ecommerceapi.service.product.ProductService;
import com.iongroup.ecommerceapi.util.ErrorUtil;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductFacade {

    private final CategoryService categoryService;

    private final ProductService productService;

    private final ProductMapper productMapper;


    public List<ProductDto> findAll(Long categoryId) {

        Optional<Category> category = categoryService.findById(categoryId);
        if (category.isEmpty()) {
            throw new NotFoundException(Category.class);
        }

        return productService.findAll()
                .stream()
                .filter(product -> product.getCategory().getId().equals(categoryId))
                .map(productMapper::convertToProductDto)
                .toList();
    }

    public ProductDto save(Long categoryId,
                           ProductDto productDto,
                           BindingResult bindingResult) {

        Optional<Category> category = categoryService.findById(categoryId);
        if (category.isEmpty()) {
            throw new NotFoundException(Category.class);
        }

        Product product = productMapper.convertToProduct(productDto);
        product.setCategory(category.get());

        try {
            product = productService.save(product);
        }
        catch (Exception ignored){}
        Optional<Product> savedProduct = productService.findById(product.getId());
        if (savedProduct.isEmpty()) {
            throw new NotSavedException(Product.class);
        }

        if (bindingResult.hasErrors()){
            ErrorUtil.returnErrors(bindingResult);
        }

        return productMapper.convertToProductDto(savedProduct.get());
    }
}
