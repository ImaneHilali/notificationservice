package com.example.notificationservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NotificationEvent implements Serializable {

    private String message;

}
