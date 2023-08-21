package com.example.yurt2.service;

import com.example.yurt2.entity.RoomFeature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryService {
    private DormitoryEntityService dormitoryEntityService;
    private RoomFeatureEntityService roomFeatureEntityService;

    public DormitoryService(DormitoryEntityService dormitoryEntityService, RoomFeatureEntityService roomFeatureEntityService) {
        this.dormitoryEntityService = dormitoryEntityService;
        this.roomFeatureEntityService = roomFeatureEntityService;
    }

    public int getCapacity(Long dormitoryId) {
        return dormitoryEntityService.getOneDormitory(dormitoryId).getGeneral_capacity();
    }
    public void updateGeneralCapacity(Long dormitoryId){
        List<RoomFeature> roomFeatures = roomFeatureEntityService.getAllRoomFeature();
        int capacity = 0;
        for (int i=0; i<roomFeatures.size();i++){
            capacity =capacity+roomFeatures.get(i).getRoomType();
        }
        dormitoryEntityService.updateGeneralCapacity(capacity,dormitoryId);
    }
}
