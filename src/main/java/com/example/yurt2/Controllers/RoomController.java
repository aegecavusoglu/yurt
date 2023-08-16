package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Entities.Room;
import com.example.yurt2.Services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/{create}")
    public Room createOneRoom(@RequestBody Room newRoom){
        return roomService.createOneRoom(newRoom);
    }

    @PutMapping("/update/{roomNumber}")
    public Room updateOneRoom(@PathVariable Long roomNumber, @RequestBody Room newRoom) {
        return roomService.updateOneRoom(roomNumber, newRoom);
    }
    @DeleteMapping("/delete/{roomId}")
    public void deleteOneRoom(@PathVariable Long roomId){
        roomService.deleteById(roomId);
    }



}
