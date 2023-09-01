package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.Cart;
import com.iongroup.ecommerceapi.repository.CartRepository;
import com.iongroup.ecommerceapi.service.interfaces.ICartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void update(Cart cart, Cart updatedCart) {
        BeanUtils.copyProperties(updatedCart, cart,
                "id", "user", "cartItems");
        cartRepository.save(cart);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}
