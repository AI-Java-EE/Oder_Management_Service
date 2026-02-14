package com.aga.demo.order.controller;

import com.aga.demo.order.dto.Order;
import com.aga.demo.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public String placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.getAll();
    }
    @PatchMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Order order) {

        order.setOrderId(id);   // Set ID from URL
        return orderService.update(order);
    }

}
