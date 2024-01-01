package com.example.notificationservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {

    private Long id;

    private String message;

    private LocalDateTime timestamp;
}
