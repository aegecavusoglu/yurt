package com.example.yurt2.exception;

public class InvalidIdentityNumberException extends RuntimeException {
    public InvalidIdentityNumberException(String message) {
        super(message);
    }
}
