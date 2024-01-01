package com.example.notificationservice.exception;

public class TokenNotValidException extends RuntimeException{

    public TokenNotValidException(){
        super("token not valid");
    }
}