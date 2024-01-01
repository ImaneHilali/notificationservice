package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.dto.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationProducer {

    @Autowired
    private KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public void sendDisasterNotification(NotificationEvent notificationEvent) {
        kafkaTemplate.send("disaster-declaration-topic", notificationEvent);

    }
}
