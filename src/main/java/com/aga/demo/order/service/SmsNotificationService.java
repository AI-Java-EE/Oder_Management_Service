package com.aga.demo.order.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class SmsNotificationService implements NotificationService {

    public SmsNotificationService() {
        System.out.println("SmsNotificationService created (lazy bean initialized now)!");
    }

    @Override
    public String send(String message) {
        return "SMS sent: " + message;
    }
}
