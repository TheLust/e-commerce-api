package com.iongroup.ecommerceapi.service.interfaces;

import com.iongroup.ecommerceapi.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface IOrderItemService {

    Optional<OrderItem> findById(Long id);
    List<OrderItem> findAll();
    void save(OrderItem orderItem);
    void update(OrderItem orderItem, OrderItem updatedOrderItem);
    void delete(Long id);
}
