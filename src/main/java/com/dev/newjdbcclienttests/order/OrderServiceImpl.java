package com.dev.newjdbcclienttests.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    final OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        orderRepository.save(order);
        return null;
    }

    @Override
    public Order delivery(Order order) {
        return null;
    }

    @Override
    public Order pay(Order order) {
        return null;
    }

    @Override
    public Order retrieve(Integer id) {
        return orderRepository.readById(id).orElse(null);
    }
}
