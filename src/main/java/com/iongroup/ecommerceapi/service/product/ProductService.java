package com.iongroup.ecommerceapi.service.product;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Product;
import com.iongroup.ecommerceapi.repository.product.ProductRepository;
import com.iongroup.ecommerceapi.service.interfaces.product.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product, Category updatedProduct) {
        BeanUtils.copyProperties(updatedProduct, product,
                "id", "inventory", "category", "orderItems", "cartItems", "reviews", "wishlist");
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
