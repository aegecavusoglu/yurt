package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Repos.RoomClassificationRepository;
import com.example.yurt2.Services.RoomClassificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
