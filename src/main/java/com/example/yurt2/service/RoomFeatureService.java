package com.example.yurt2.service;


import com.example.yurt2.entity.RoomFeature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;


@Service
public class RoomFeatureService {
    RoomFeatureEntityService roomFeatureEntityService;
    StudentContractService studentContractService;
    DormitoryService dormitoryService;
    private final TransactionTemplate transactionTemplate;

    public RoomFeatureService(RoomFeatureEntityService roomFeatureEntityService, StudentContractService studentContractService, PlatformTransactionManager transactionTemplate, DormitoryService dormitoryService ) {
        this.roomFeatureEntityService = roomFeatureEntityService;
        this.studentContractService = studentContractService;
        this.transactionTemplate = new TransactionTemplate(transactionTemplate);
        this.dormitoryService = dormitoryService;
    }


    public RoomFeature createRoomFeatureInstance(RoomFeature roomFeature){
        RoomFeature newRoomFeature = new RoomFeature();
        newRoomFeature.setRoomId(roomFeature.getRoomId());
        newRoomFeature.setRoomType(roomFeature.getRoomType());
        newRoomFeature.setPrice(roomFeature.getPrice());
        newRoomFeature.setInstantRoomCapacity(studentContractService.findActiveStudentsNumberByRoomId(roomFeature.getRoomId()));
        newRoomFeature.setFull(isRoomFull(roomFeature));
        return roomFeature;
    }
    public RoomFeature createRoomFeatureAndUpdateCapacity(RoomFeature newRoomFeature){
        var roomStatus = transactionTemplate.execute(p-> {
            RoomFeature roomFeature = roomFeatureEntityService.createOneRoomFeature(createRoomFeatureInstance(newRoomFeature));
            dormitoryService.updateGeneralCapacity(findDormitoryId(newRoomFeature.getRoomId()));
            return roomFeature;
        });
        return roomStatus;
    }
    public RoomFeature getOneRoomFeatureByRoomId(Long roomId) {
        return roomFeatureEntityService.getOneRoomFeatureByRoomId(roomId);

    }
    public List<RoomFeature> getAllRoomFeature(){
        return roomFeatureEntityService.getAllRoomFeature();
    }
    public Long findDormitoryId(Long roomId){
        return roomFeatureEntityService.findDormitoryId(roomId);
    }
    public boolean isRoomFull(RoomFeature roomFeature){
        int remainCapacity=roomFeature.getRoomType()-roomFeature.getInstantRoomCapacity();
        return remainCapacity == 0;
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
    public void increaseInstanceRoomCapacity(Long roomId){
        RoomFeature roomFeature = roomFeatureEntityService.getOneRoomFeatureByRoomId(roomId);
        int instanceRoomCapacity = roomFeature.getInstantRoomCapacity()+1;
        roomFeatureEntityService.updateInstanceRoomCapacity(roomId,instanceRoomCapacity);
        if (roomFeature.getInstantRoomCapacity()==roomFeature.getRoomType()){
            roomFeature.setFull(true);
        }
    }
    public void decreaseInstanceRoomCapacity(Long roomId){
        RoomFeature roomFeature = roomFeatureEntityService.getOneRoomFeatureByRoomId(roomId);
        int instanceRoomCapacity = roomFeature.getInstantRoomCapacity()-1;
        roomFeatureEntityService.updateInstanceRoomCapacity(roomId,instanceRoomCapacity);
        if (roomFeature.isFull()){
            roomFeature.setFull(false);
        }
    }
}
