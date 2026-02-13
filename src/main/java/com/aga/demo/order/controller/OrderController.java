package com.aga.demo.order.controller;

import com.aga.demo.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{id}")
    public String placeOrder(
            @PathVariable String id,
            @RequestParam(defaultValue = "false") boolean sms
    ) {
        return orderService.placeOrder(id, sms);
    }
}
