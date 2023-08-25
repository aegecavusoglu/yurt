package com.example.yurt2.service;

import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.entity.Student;
import com.example.yurt2.entity.StudentRoomRelation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DormitoryService {
    private DormitoryEntityService dormitoryEntityService;
    private RoomFeatureEntityService roomFeatureEntityService;
    private StudentService studentService;

    public DormitoryService(DormitoryEntityService dormitoryEntityService, RoomFeatureEntityService roomFeatureEntityService,StudentService studentService) {
        this.dormitoryEntityService = dormitoryEntityService;
        this.roomFeatureEntityService = roomFeatureEntityService;
        this.studentService= studentService;
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

    public int getFreeCapacity(Long dormitoryId) {
        return dormitoryEntityService.getOneDormitory(dormitoryId).getGeneral_capacity()-getCurrentFullCapacity(dormitoryId);
    }
    public int getCurrentFullCapacity(Long dormitoryId){
        List<RoomFeature> roomFeatures=roomFeatureEntityService.getAllRoomFeature();
        int currentCapacity=0;
        for (int i=0;i<roomFeatures.size();i++){
            currentCapacity+=roomFeatures.get(i).getInstantRoomCapacity();
        }
        return currentCapacity;
    }

    public List<RoomFeature> getFreeRooms() {
        List<RoomFeature> roomFeatures= roomFeatureEntityService.getFreeRooms();
        return roomFeatures;
    }

    public List<String> getSchoolList() {
        return studentService.getSchoolListWithStudentCount();
    }
}
