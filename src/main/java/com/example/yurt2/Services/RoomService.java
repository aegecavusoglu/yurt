package com.example.yurt2.Services;

import org.springframework.stereotype.Service;

@Service
public class RoomService {
    RoomEntityService roomEntityService;

    public RoomService(RoomEntityService roomEntityService) {
        this.roomEntityService = roomEntityService;
    }

}
