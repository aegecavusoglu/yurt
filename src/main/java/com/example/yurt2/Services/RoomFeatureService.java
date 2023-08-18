package com.example.yurt2.Services;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.RoomClassification;
import com.example.yurt2.Entities.RoomFeature;
import org.springframework.stereotype.Service;

@Service
public class RoomFeatureService {
    RoomFeatureEntityService roomFeatureEntityService;
    StudentContractEntityService studentContractEntityService;
    RoomClassificationEntityService roomClassificationEntityService;
    public RoomFeatureService(RoomFeatureEntityService roomFeatureEntityService, StudentContractEntityService studentContractEntityService, RoomClassificationEntityService roomClassificationEntityService) {
        this.roomFeatureEntityService = roomFeatureEntityService;
        this.studentContractEntityService = studentContractEntityService;
        this.roomClassificationEntityService = roomClassificationEntityService;
    }

    public RoomFeature createRoomFeature(Room room){
        return roomFeatureEntityService.createOneRoomFeature(createRoomFeatureInstance(room));
    }
    public RoomFeature createRoomFeatureInstance(Room room){
        RoomFeature roomFeature = new RoomFeature();
        RoomClassification roomClassification = findRoomClassification(room);
        roomFeature.setId(2L);
        roomFeature.setRoomId(room.getId());
        roomFeature.setRoomType(roomClassification.getRoomType());
        roomFeature.setPrice(roomClassification.getPrice());
        roomFeature.setInstantRoomCapacity(studentContractEntityService.findActiveStudentsNumberByRoomId(room.getId()));
        roomFeature.setFull(isRoomFull(roomFeature));
        return roomFeature;
    }
    public RoomClassification findRoomClassification(Room room){
       return roomClassificationEntityService.getOneRoomClassification(room.getRoomClassificationId()).get();
    }
    public boolean isRoomFull(RoomFeature roomFeature){
        int remainCapacity=roomFeature.getRoomType()-roomFeature.getInstantRoomCapacity();
        if (remainCapacity==0){
            return true;
        }
        else
            return false;
    }


}
