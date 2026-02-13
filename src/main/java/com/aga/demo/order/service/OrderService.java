package com.aga.demo.order.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final NotificationService defaultNotification; // will use @Primary
    private final NotificationService smsNotification;     // will use @Qualifier

    public OrderService(
            NotificationService defaultNotification,
            @Qualifier("smsNotificationService") NotificationService smsNotification
    ) {
        this.defaultNotification = defaultNotification;
        this.smsNotification = smsNotification;
    }

    public String placeOrder(String orderId, boolean useSms) {
        String msg = "Order placed. id=" + orderId;

        if (useSms) {
            return smsNotification.send(msg);
        }
        return defaultNotification.send(msg);
    }
}