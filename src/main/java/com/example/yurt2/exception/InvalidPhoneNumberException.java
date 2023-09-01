package com.example.yurt2.exception;

public class InvalidPhoneNumberException extends RuntimeException{
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
