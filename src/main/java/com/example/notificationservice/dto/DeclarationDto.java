package com.example.notificationservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data

public class DeclarationDto {

    private Long id;

    @NotBlank(message = "this is required")
    private String fullName;

    @NotNull(message = "Phone Number is required")
    private Integer phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    private String description;


    @NotNull(message = "Localisation is required")
    private PointDto localisation;

}