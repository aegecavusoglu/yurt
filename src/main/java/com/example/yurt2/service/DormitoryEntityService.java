package com.example.yurt2.service;

import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.repository.DormitoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DormitoryEntityService {
    private DormitoryRepository dormitory_repository;
    private RoomFeatureEntityService roomFeatureEntityService;


    public DormitoryEntityService(DormitoryRepository dormitoryRepository, RoomFeatureEntityService roomFeatureEntityService) {
        this.dormitory_repository = dormitoryRepository;
        this.roomFeatureEntityService = roomFeatureEntityService;
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

}
