package com.example.yurt2.Services;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Repos.RoomClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoomClassificationService {
    RoomClassificationRepository roomClassificationRepository;

    public RoomClassificationService(RoomClassificationRepository roomClassificationRepository) {
        this.roomClassificationRepository = roomClassificationRepository;
    }

    public List<RoomClassification> getAllRoomTypes() {
        return roomClassificationRepository.findAll();
    }

    public RoomClassification getOneRoomType(Long roomType) {
        return roomClassificationRepository.findByRoomType(roomType).orElse(null);
    }

    public RoomClassification createOneRoomClassification(RoomClassification newRoomClassification) {
        return roomClassificationRepository.save(newRoomClassification);
    }

    public RoomClassification updateOneRoomClassification(Long roomType, RoomClassification newRoomClassification) {
        Optional<RoomClassification> roomClassification=roomClassificationRepository.findByRoomType((roomType));
        if(roomClassification.isPresent()){
            RoomClassification foundRoomClassification=roomClassification.get();
            foundRoomClassification.setRoomType(newRoomClassification.getRoomType());
            foundRoomClassification.setPrice(newRoomClassification.getPrice());
            roomClassificationRepository.save(foundRoomClassification);
            return foundRoomClassification;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long roomType) {
        roomClassificationRepository.deleteById(roomType);
    }
}
