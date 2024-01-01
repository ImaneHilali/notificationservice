package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.dto.NotificationDto;
import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import com.example.notificationservice.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final AdminNotificationService adminNotificationService;

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl( AdminNotificationService adminNotificationService, NotificationRepository notificationRepository) {
        this.adminNotificationService = adminNotificationService;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<NotificationDto> getNotificationsByAdminId(Long adminId) {
        List<Notification> notifications = notificationRepository.findByAdminId(adminId);
        return notifications.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private NotificationDto convertToDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setId(notification.getId());
        dto.setMessage(notification.getMessage());
        dto.setTimestamp(notification.getTimestamp());
        return dto;
    }

    public void processDisasterDeclaration(NotificationEvent notificationEvent) {
        String declarationMessage = notificationEvent.getMessage();
        adminNotificationService.notifyAdmin(declarationMessage);

    }

}
