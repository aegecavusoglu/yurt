package com.example.yurt2.exception;

public class NoFreeRoomException extends RuntimeException{
    public NoFreeRoomException(String message) {
        super(message);
    }

}
