package com.example.yurt2.Services;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Entities.RoomFeature;
import com.example.yurt2.Repos.DormitoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DormitoryService {
    private DormitoryRepository dormitory_repository;
    private RoomFeatureService roomFeatureService;


    public DormitoryService(DormitoryRepository dormitoryRepository,RoomFeatureService roomFeatureService) {
        this.dormitory_repository = dormitoryRepository;
        this.roomFeatureService = roomFeatureService;
    }
    public List<Dormitory> getAllDormitories() {
        return dormitory_repository.findAll();
    }
    public Dormitory getOneDormitory(Long dormitoryId) {
        return dormitory_repository.findById(dormitoryId).orElse(null);
    }

    public Dormitory createOneDormitory(Dormitory new_dormitory) {
        return dormitory_repository.save(new_dormitory);
    }


    public Dormitory updateOneDormitory(Long dormitory_id, Dormitory newDormitory) {
        Optional<Dormitory> dormitory=dormitory_repository.findById((dormitory_id));
        if(dormitory.isPresent()){
            Dormitory foundDormitory=dormitory.get();
            foundDormitory.setName(newDormitory.getName());
            foundDormitory.setGeneral_capacity(newDormitory.getGeneral_capacity());
            dormitory_repository.save(foundDormitory);
            return foundDormitory;
        }
        else{
            return null;
        }
    }
    public void updateGeneralCapacity(int generalCapacity, Long dormitoryId){
        Optional<Dormitory> dormitory=dormitory_repository.findById((dormitoryId));
        if(dormitory.isPresent()){
            Dormitory foundDormitory=dormitory.get();
            foundDormitory.setGeneral_capacity(generalCapacity);
            dormitory_repository.save(foundDormitory);
        }
    }



    public void deleteById(Long dormitory_id) {
        dormitory_repository.deleteById(dormitory_id);
    }

    public int getCapacity(Long dormitoryId) {
        List<RoomFeature> roomFeatures = roomFeatureService.getAllRoomFeature();
        int capacity = 0;
        for (int i=0; i<roomFeatures.size();i++){
            capacity =capacity+roomFeatures.get(i).getRoomType();
        }
        updateGeneralCapacity(capacity,dormitoryId);
        return  capacity;
    }
}
