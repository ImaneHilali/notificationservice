package com.example.notificationservice.exception;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(){
        super("admin not found");
    }
}