package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Services.RoomClassificationEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")//??rooms??
public class RoomClassificationController {
    RoomClassificationEntityService roomClassificationEntityService;

    public RoomClassificationController(RoomClassificationEntityService roomClassificationEntityService) {
        this.roomClassificationEntityService = roomClassificationEntityService;
    }
    @GetMapping
    public List<RoomClassification> getAllRoomTypes(){
        return roomClassificationEntityService.getAllRoomTypes();
    }

    @GetMapping("/rooms/{roomType}")
    public RoomClassification getOneRoomType(@PathVariable Long roomType){
        return roomClassificationEntityService.getOneRoomType(roomType);
    }
    @PostMapping("/create")
    public RoomClassification createOneRoomClassification(@RequestBody RoomClassification newRoomClassification){
        return roomClassificationEntityService.createOneRoomClassification(newRoomClassification);
    }
    @PutMapping("/update/{roomType}")
    public RoomClassification updateOneRoomClassification(@PathVariable Long roomType,@RequestBody RoomClassification newRoomClassification){
        return roomClassificationEntityService.updateOneRoomClassification(roomType,newRoomClassification);
    }
    @DeleteMapping("/delete/{roomType}")
    public void deleteOneRoomClassification(@PathVariable Long roomType){
        roomClassificationEntityService.deleteById(roomType);
    }


}
