package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.RoomFeature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

import java.util.List;

@Service
public class RoomFeatureService {
    RoomFeatureEntityService roomFeatureEntityService;
    StudentContractEntityService studentContractEntityService;
    DormitoryService dormitoryService;
    private final TransactionTemplate transactionTemplate;

    public RoomFeatureService(RoomFeatureEntityService roomFeatureEntityService, StudentContractEntityService studentContractEntityService, PlatformTransactionManager transactionTemplate, DormitoryService dormitoryService ) {
        this.roomFeatureEntityService = roomFeatureEntityService;
        this.studentContractEntityService = studentContractEntityService;
        this.transactionTemplate = new TransactionTemplate(transactionTemplate);
        this.dormitoryService = dormitoryService;
    }

    public RoomFeature createRoomFeature(RoomFeature roomFeature){
        return roomFeatureEntityService.createOneRoomFeature(createRoomFeatureInstance(roomFeature));
    }
    public RoomFeature createRoomFeatureInstance(RoomFeature roomFeature){
        RoomFeature newRoomFeature = new RoomFeature();
        newRoomFeature.setRoomId(roomFeature.getId());
        newRoomFeature.setRoomType(roomFeature.getRoomType());
        newRoomFeature.setPrice(roomFeature.getPrice());
        newRoomFeature.setInstantRoomCapacity(studentContractEntityService.findActiveStudentsNumberByRoomId(roomFeature.getRoomId()));
        newRoomFeature.setFull(isRoomFull(roomFeature));
        return roomFeature;
    }
    public RoomFeature createRoomFeatureAndUpdateCapacity(RoomFeature newRoomFeature){
        var roomStatus = transactionTemplate.execute(p-> {
            RoomFeature roomFeature = roomFeatureEntityService.createOneRoomFeature(newRoomFeature);
            dormitoryService.updateGeneralCapacity(findDormitoryId(newRoomFeature.getRoomId()));
            return roomFeature;
        });
        return roomStatus;
    }
    public Long findDormitoryId(Long roomId){
        return roomFeatureEntityService.findDormitoryId(roomId);
    }
    public boolean isRoomFull(RoomFeature roomFeature){
        int remainCapacity=roomFeature.getRoomType()-roomFeature.getInstantRoomCapacity();
        if (remainCapacity==0){
            return true;
        }
        else
            return false;
    }
    public RoomFeature updateOneRoomFeature(Long roomId, RoomFeature newRoomFeature) {
        var roomFeature = roomFeatureEntityService.updateOneRoomFeature(roomId,newRoomFeature);
        dormitoryService.updateGeneralCapacity(findDormitoryId(newRoomFeature.getId()));
        return roomFeature;
    }
    public void deleteRoomFeatureByRoomId(Long roomId){
        roomFeatureEntityService.deleteRoomFeatureById(roomId);
        dormitoryService.updateGeneralCapacity(findDormitoryId(roomId));
    }

    public List<RoomFeature> findTheMostCrowdedRoom() {
        return roomFeatureEntityService.findTheMostCrowdedRoom();
    }
}
