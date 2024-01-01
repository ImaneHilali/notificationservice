package com.example.notificationservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PointDto {

    @NotNull(message = "Latitude is required")
    private double latitude;

    @NotNull(message = "Longitude is required")
    private double longitude;

}