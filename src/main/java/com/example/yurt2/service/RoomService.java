package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoomService {
    RoomEntityService roomEntityService;
    RoomFeatureService roomFeatureService;
    DormitoryService dormitoryService;

    public RoomService(RoomEntityService roomEntityService, DormitoryService dormitoryService, RoomFeatureService roomFeatureService) {
        this.roomEntityService = roomEntityService;
        this.dormitoryService = dormitoryService;
        this.roomFeatureService = roomFeatureService;
    }
    public List<Room> getAllRooms() {
        return roomEntityService.getAllRooms();
    }
    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomEntityService.getOneRoomByRoomNumber(roomNumber);

    }
    public Room createRoom(Room newRoom) {
       return roomEntityService.createOneRoom(newRoom);
    }

    public Room updateRoom(Long roomNumber, Room newRoom) {
        var room = roomEntityService.updateOneRoom(roomNumber,newRoom);
        return room;
    }

    public void deleteById(Long roomId)
    {
        roomEntityService.deleteById(roomId);
    }

}
