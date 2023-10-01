package com.dev.newjdbcclienttests.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;

    @PostMapping
    public Order newOrder(@RequestBody Order order) {
        order = orderService.create(order);
        return order;
    }

    @GetMapping("{id}")
    public Order newOrder(@PathVariable Integer id) {
        return orderService.retrieve(id);
    }


}
