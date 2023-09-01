package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemService {

    Optional<CartItem> findById(Long id);
    List<CartItem> findAll();
    void save(CartItem cartItem);
    void update(CartItem cartItem, CartItem updatedCartItem);
    void delete(Long id);
}
