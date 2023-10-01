package com.dev.newjdbcclienttests.order;


public interface OrderService {
    Order create(Order order);

    Order delivery(Order order);

    Order pay(Order order);

    Order retrieve(Integer id);

}
