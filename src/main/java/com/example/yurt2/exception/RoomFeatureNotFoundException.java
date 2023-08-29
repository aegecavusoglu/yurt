package com.example.yurt2.exception;

public class RoomFeatureNotFoundException extends RuntimeException{
    public RoomFeatureNotFoundException(String message) {
        super(message);
    }
}
