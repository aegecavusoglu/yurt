package com.example.yurt2.Services;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomFeature;
import com.example.yurt2.Repos.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class RoomService{
    RoomRepository roomRepository;
    DormitoryService dormitoryService;

    public RoomService(RoomRepository roomRepository,DormitoryService dormitoryService )
    {
        this.roomRepository = roomRepository;
        this.dormitoryService = dormitoryService;
    }


    public List<Room> getAllRooms() {

        return roomRepository.findAll();

    }

    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElse(null);

    }

    public Room createOneRoom(Room newRoom) {
        roomRepository.save(newRoom);
        dormitoryService.getCapacity(roomRepository.findDormitoryId(newRoom.getId()));
        return newRoom;
    }

    public Room updateOneRoom(Long roomNumber, Room newRoom) {
        Optional<Room> room=roomRepository.findByRoomNumber((roomNumber));
        if(room.isPresent()){
            Room foundRoom=room.get();
            foundRoom.setRoomNumber(newRoom.getRoomNumber());
            foundRoom.setRoomClassificationId(newRoom.getRoomClassificationId());
            roomRepository.save(foundRoom);
            dormitoryService.getCapacity(roomRepository.findDormitoryId(newRoom.getId()));
            return foundRoom;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long roomId)
    {
        roomRepository.deleteById(roomId);
        Optional<Room> room =roomRepository.findById(roomId);
        Room foundRoom = room.get();
        dormitoryService.getCapacity(roomRepository.findDormitoryId(roomId));
    }
}
