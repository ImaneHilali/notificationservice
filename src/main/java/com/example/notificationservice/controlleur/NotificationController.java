package com.example.notificationservice.controlleur;

import com.example.notificationservice.dto.NotificationDto;
import com.example.notificationservice.dto.NotificationEvent;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<NotificationDto>> getNotificationsByAdminId(@PathVariable Long adminId) {
        List<NotificationDto> notifications = notificationService.getNotificationsByAdminId(adminId);
        return ResponseEntity.ok(notifications);
    }

    @PostMapping("/process-disaster")
    public ResponseEntity<String> processDisasterNotification(@RequestBody NotificationEvent notificationEvent) {
        notificationService.processDisasterDeclaration(notificationEvent);
        return ResponseEntity.ok("Disaster notification processed successfully.");
    }
}
