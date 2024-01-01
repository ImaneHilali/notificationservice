package com.example.notificationservice.exception;

public class AdminNotFoundWithEmailException extends RuntimeException{

    public AdminNotFoundWithEmailException(){
        super("Admin not found with this email");
    }
}