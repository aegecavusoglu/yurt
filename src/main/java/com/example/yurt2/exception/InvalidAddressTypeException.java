package com.example.yurt2.exception;

public class InvalidAddressTypeException extends RuntimeException {
    public InvalidAddressTypeException(String message) {
        super(message);
    }
}
