package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void update(Order order, Order updatedOrder);
    void delete(Long id);
}
