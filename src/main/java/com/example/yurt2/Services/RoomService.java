package com.example.yurt2.Services;

import com.example.yurt2.Repos.RoomRepository;
import org.springframework.stereotype.Service;

@Service

public class RoomService {
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
