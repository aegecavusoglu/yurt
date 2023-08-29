package com.example.yurt2.exception;

public class RoomRelationNotFoundException extends RuntimeException{
    public RoomRelationNotFoundException(String message) {
        super(message);
    }
}
