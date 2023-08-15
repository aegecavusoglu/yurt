package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Repos.RoomClassificationRepository;
import com.example.yurt2.Services.RoomClassificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")//??rooms??
public class RoomClassificationController {
    RoomClassificationService roomClassificationService;

    public RoomClassificationController(RoomClassificationService roomClassificationService) {
        this.roomClassificationService = roomClassificationService;
    }
    @GetMapping
    public List<RoomClassification> getAllRoomTypes(){
        return roomClassificationService.getAllRoomTypes();
    }

    @GetMapping("/rooms/{roomType}")
    public RoomClassification getOneRoomType(@PathVariable Long roomType){
        return roomClassificationService.getOneRoomType(roomType);
    }
    @PostMapping("/create")
    public RoomClassification createOneRoomClassification(@RequestBody RoomClassification newRoomClassification){
        return roomClassificationService.createOneRoomClassification(newRoomClassification);
    }
    @PutMapping("/update/{roomType}")
    public RoomClassification updateOneRoomClassification(@PathVariable Long roomType,@RequestBody RoomClassification newRoomClassification){
        return roomClassificationService.updateOneRoomClassification(roomType,newRoomClassification);
    }
    @DeleteMapping("/delete/{roomType}")
    public void deleteOneRoomClassification(@PathVariable Long roomType){
        roomClassificationService.deleteById(roomType);
    }


}
