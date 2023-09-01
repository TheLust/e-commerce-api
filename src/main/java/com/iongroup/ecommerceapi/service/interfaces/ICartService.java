package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    Optional<Cart> findById(Long id);
    List<Cart> findAll();
    void save(Cart cart);
    void update(Cart cart, Cart updatedCart);
    void delete(Long id);
}
