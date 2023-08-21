package com.example.yurt2.controller;

import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.service.RoomFeatureEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomfeature")
public class RoomFeatureController {
    RoomFeatureEntityService roomFeatureEntityService;

    public RoomFeatureController(RoomFeatureEntityService roomFeatureEntityService) {
        this.roomFeatureEntityService = roomFeatureEntityService;
    }
    @PostMapping("/create")
    public RoomFeature createRoomFeature(@RequestBody RoomFeature roomFeature)
    {return roomFeatureEntityService.createOneRoomFeature(roomFeature);}

    @GetMapping
    public List<RoomFeature> getAllRoomFeature()
    {return roomFeatureEntityService.getAllRoomFeature();}
    @GetMapping("/{roomId}")
    public RoomFeature getOneRoomFeatureByRoomId(@PathVariable Long roomId)
    {return roomFeatureEntityService.getOneRoomFeatureByRoomId(roomId);}
    @PutMapping("/update/{roomId}")
    public RoomFeature updateOneRoomFeature(@PathVariable Long roomId,@RequestBody RoomFeature roomFeature)
    {
        return roomFeatureEntityService.updateOneRoomFeature(roomId,roomFeature);
    }
}
