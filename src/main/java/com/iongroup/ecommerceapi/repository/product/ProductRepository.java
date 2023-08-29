package com.iongroup.ecommerceapi.repository.product;

import com.iongroup.ecommerceapi.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
