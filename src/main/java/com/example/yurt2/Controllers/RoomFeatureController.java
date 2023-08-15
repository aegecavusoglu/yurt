package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.RoomFeature;
import com.example.yurt2.Services.RoomFeatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomfeature")
public class RoomFeatureController {
    RoomFeatureService roomFeatureService;

    public RoomFeatureController(RoomFeatureService roomFeatureService) {
        this.roomFeatureService = roomFeatureService;
    }
    @PostMapping("/create")
    public RoomFeature createRoomFeature(@RequestBody RoomFeature roomFeature)
    {return roomFeatureService.createOneRoomFeature(roomFeature);}

    @GetMapping
    public List<RoomFeature> getAllRoomFeature()
    {return roomFeatureService.getAllRoomFeature();}
    @GetMapping("/{roomId}")
    public RoomFeature getOneRoomFeatureByRoomId(@PathVariable Long roomId)
    {return roomFeatureService.getOneRoomFeatureByRoomId(roomId);}
    @PutMapping("/update/{roomId}")
    public RoomFeature updateOneRoomFeature(@PathVariable Long roomId,@RequestBody RoomFeature roomFeature)
    {
        return roomFeatureService.updateOneRoomFeature(roomId,roomFeature);
    }
}
