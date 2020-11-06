package com.twuc.shopping.service;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class OrderService {
    final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }
    public List<OrderPO> findAll() {
        return orderRepository.findAll();
    }
}
