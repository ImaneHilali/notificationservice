package com.example.notificationservice.service;

import com.example.notificationservice.dto.NotificationDto;
import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {

    List<NotificationDto> getNotificationsByAdminId(Long adminId);

    public void processDisasterDeclaration(NotificationEvent notificationEvent);


}
