package com.example.yurt2.controller;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.Student;
import com.example.yurt2.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public Room getOneRoom(@PathVariable Long roomNumber){
        return roomService.getOneRoomByRoomNumber(roomNumber);
    }

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room newRoom){
        return roomService.createRoom(newRoom);
    }

    @PutMapping("/update/{roomNumber}")
    public Room updateOneRoom(@PathVariable Long roomNumber, @RequestBody Room newRoom) {
        return roomService.updateRoom(roomNumber, newRoom);
    }
    @DeleteMapping("/delete/{roomId}")
    public void deleteOneRoom(@PathVariable Long roomId){
        roomService.deleteById(roomId);
    }

   @GetMapping("/getStudentInOneRoom/{roomNumber}")
    public List<Student> getStudentInOneRoom(@PathVariable Long roomNumber){
        return roomService.getStudentInOneRoom(roomNumber);
    }



}
