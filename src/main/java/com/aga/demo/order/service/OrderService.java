package com.aga.demo.order.service;

import com.aga.demo.order.dto.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final NotificationService defaultNotification; // will use @Primary
    private final NotificationService smsNotification;     // will use @Qualifier
    private final Map<Long, Order> orderStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public OrderService(
            NotificationService defaultNotification,
            @Qualifier("smsNotificationService") NotificationService smsNotification
    ) {
        this.defaultNotification = defaultNotification;
        this.smsNotification = smsNotification;
    }

    public String placeOrder(Order order) {
        Long id = idGenerator.getAndIncrement();
        order.setOrderId(id);
        order.setStatus(true);
        order.setName(order.getName());

        orderStore.put(id, order);
        return "Order placed successfully with id: " + id;
    }

    public Order getOrder(Long id) {
        return orderStore.get(id);
    }

    public List<Order> getAll() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.addAll(orderStore.values());
        return orders;
    }
}