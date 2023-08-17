package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Services.RoomEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomEntityService roomEntityService;

    public RoomController(RoomEntityService roomEntityService) {
        this.roomEntityService = roomEntityService;
    }
    @GetMapping
    public List<Room> getAllRooms(){
        return roomEntityService.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public Room getOneRoom(@PathVariable Long roomNumber){
        return roomEntityService.getOneRoomByRoomNumber(roomNumber);
    }

    @PostMapping("/create")
    public Room createOneRoom(@RequestBody Room newRoom){
        return roomEntityService.createOneRoom(newRoom);
    }

    @PutMapping("/update/{roomNumber}")
    public Room updateOneRoom(@PathVariable Long roomNumber, @RequestBody Room newRoom) {
        return roomEntityService.updateOneRoom(roomNumber, newRoom);
    }
    @DeleteMapping("/delete/{roomId}")
    public void deleteOneRoom(@PathVariable Long roomId){
        roomEntityService.deleteById(roomId);
    }



}
