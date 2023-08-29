package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.exception.RoomNotFoundException;
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

        //return roomRepository.findAll();
        List<Room> rooms = roomRepository.findAll();
        if(rooms.isEmpty()){
            throw new RoomNotFoundException("Rooms could not found");

        }
        else{
            return rooms;
        }
    }


    public Room getOneRoomByRoomNumber(Long roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(()->new RoomNotFoundException("Room with roomNumber:" + roomNumber + " is not found."));

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
            throw new RoomNotFoundException("Room with roomNumber:" + roomNumber + " is not found.");
        }
    }

    public void deleteById(Long roomId)
    {
        //roomRepository.deleteById(roomId);
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.isPresent()){
            roomRepository.deleteById(roomId);
        }
        else{
            throw new RoomNotFoundException("Room with id:" + roomId +" is not found.");
        }
    }



}
