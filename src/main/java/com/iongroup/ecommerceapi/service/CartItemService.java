package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.CartItem;
import com.iongroup.ecommerceapi.repository.CartItemRepository;
import com.iongroup.ecommerceapi.service.interfaces.ICartItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartItemService implements ICartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void update(CartItem cartItem, CartItem updatedCartItem) {
        BeanUtils.copyProperties(updatedCartItem, cartItem,
                "id", "cart", "product");
        cartItemRepository.save(cartItem);
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }
}
