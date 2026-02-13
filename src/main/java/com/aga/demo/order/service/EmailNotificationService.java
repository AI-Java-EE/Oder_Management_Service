package com.aga.demo.order.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class EmailNotificationService implements  NotificationService {

    @Override
    public String send(String message) {
        return "EMAIL sent: " + message;
    }
}
