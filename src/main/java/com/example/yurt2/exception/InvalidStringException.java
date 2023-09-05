package com.example.yurt2.exception;

public class InvalidStringException extends RuntimeException{
    public InvalidStringException(String message) {
        super(message);
    }
}
