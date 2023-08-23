package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class RoomEntityService {
    RoomRepository roomRepository;

    public RoomEntityService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {

        return roomRepository.findAll();


    }

    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElse(null);

    }

    public Room createOneRoom(Room newRoom) {
         return roomRepository.save(newRoom);
    }

    public Room updateOneRoom(Long roomNumber, Room newRoom) {
        Optional<Room> room=roomRepository.findByRoomNumber((roomNumber));
        if(room.isPresent()){
            Room foundRoom=room.get();
            foundRoom.setRoomNumber(newRoom.getRoomNumber());
            roomRepository.save(foundRoom);
            return foundRoom;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long roomId)
    {
        roomRepository.deleteById(roomId);
    }



}
