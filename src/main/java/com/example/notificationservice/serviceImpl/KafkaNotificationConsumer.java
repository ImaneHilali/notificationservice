package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationConsumer {

    @Autowired
    public AdminNotificationService adminNotificationService;


    public KafkaNotificationConsumer(AdminNotificationService adminNotificationService) {
        this.adminNotificationService = adminNotificationService ;
    }

    @KafkaListener(topics = "disaster-declaration-topic", groupId = "disaster-notification-group")
    public void listenForDisasterDeclaration(NotificationEvent notificationEvent) {
        // Process the notification event and send actual notifications to admins
        adminNotificationService.notifyAdmin(notificationEvent.getMessage());

    }
}

