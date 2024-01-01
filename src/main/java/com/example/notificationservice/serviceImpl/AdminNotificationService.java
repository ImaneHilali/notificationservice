package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.model.Admin;
import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AdminNotificationService {

    private final AdminServiceImpl adminService;

    private final NotificationRepository notificationRepository;

    private final KafkaNotificationProducer kafkaNotificationProducer;


    @Autowired
    public AdminNotificationService(AdminServiceImpl adminService, NotificationRepository notificationRepository, KafkaNotificationProducer kafkaNotificationProducer) {
        this.adminService = adminService;
        this.notificationRepository = notificationRepository;
        this.kafkaNotificationProducer = kafkaNotificationProducer;
    }

    public void notifyAdmin(String message) {

        List<Admin> admins = adminService.getAllAdmins();

        for (Admin admin : admins) {
            sendNotificationToAdmin(admin, message);
        }
    }

    private void sendNotificationToAdmin(Admin admin, String message) {
        Notification notification = new Notification();
        notification.setMessage(message);

        notification.getAdmins().add(admin);
        admin.getNotifications().add(notification);

        notificationRepository.save(notification);

        //To send a Kafka notification
        NotificationEvent notificationEvent = new NotificationEvent();
        notificationEvent.setMessage(message);
        kafkaNotificationProducer.sendDisasterNotification(notificationEvent);

        System.out.println("Admin notified (" + admin.getEmail() + "): " + message);
    }

}
