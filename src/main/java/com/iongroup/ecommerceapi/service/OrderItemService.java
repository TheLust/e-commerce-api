package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.OrderItem;
import com.iongroup.ecommerceapi.repository.OrderItemRepository;
import com.iongroup.ecommerceapi.service.interfaces.IOrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemService implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void update(OrderItem orderItem, OrderItem updatedOrderItem) {
        BeanUtils.copyProperties(updatedOrderItem, orderItem,
                "id", "order", "product");
        orderItemRepository.save(orderItem);
    }

    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}
