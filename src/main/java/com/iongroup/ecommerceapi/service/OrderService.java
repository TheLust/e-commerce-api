package com.iongroup.ecommerceapi.service;

import com.iongroup.ecommerceapi.entity.Order;
import com.iongroup.ecommerceapi.repository.OrderRepository;
import com.iongroup.ecommerceapi.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order, Order updatedOrder) {
        BeanUtils.copyProperties(updatedOrder, order,
                "id");
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
