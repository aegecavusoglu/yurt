package com.example.yurt2.controller;

import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.service.RoomFeatureEntityService;
import com.example.yurt2.service.RoomFeatureService;
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
    {return roomFeatureService.createRoomFeatureAndUpdateCapacity(roomFeature);}

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
    @GetMapping("/mostcrowdedroom")
    public List<RoomFeature> findTheMostCrowdedRoom(){
        return roomFeatureService.findTheMostCrowdedRoom();
    }
}
