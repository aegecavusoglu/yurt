package com.example.yurt2.Services;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Repos.RoomClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoomClassificationService {
    RoomClassificationRepository roomClassificationRepository;

    public List<RoomClassification> getAllRoomTypes() {
        return roomClassificationRepository.findAll();
    }

    public RoomClassification getOneRoomType(Long roomType) {
        return roomClassificationRepository.findByRoomType(roomType).orElse(null);
    }
}
