package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.exception.DormitoryNotFoundException;
import com.example.yurt2.repository.DormitoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DormitoryEntityService {
    private DormitoryRepository dormitoryRepository;
    private RoomFeatureEntityService roomFeatureEntityService;


    public DormitoryEntityService(DormitoryRepository dormitoryRepository, RoomFeatureEntityService roomFeatureEntityService) {
        this.dormitoryRepository = dormitoryRepository;
        this.roomFeatureEntityService = roomFeatureEntityService;
    }
    public List<Dormitory> getAllDormitories() {
        //return dormitory_repository.findAll();
        List<Dormitory> dormitories = dormitoryRepository.findAll();
        if(dormitories.isEmpty()){
            throw new AddressNotFoundException("Dormitory could not found.");

        }
        else{
            return dormitories;
        }
    }
    public Dormitory getOneDormitory(Long dormitoryId) {
        return dormitoryRepository.findById(dormitoryId).orElseThrow(()->new DormitoryNotFoundException("Dormitory could not found by this id."));
    }

    public Dormitory createOneDormitory(Dormitory new_dormitory) {
        return dormitoryRepository.save(new_dormitory);
    }


    public Dormitory updateOneDormitory(Long dormitory_id, Dormitory newDormitory) {
        Optional<Dormitory> dormitory=dormitoryRepository.findById((dormitory_id));
        if(dormitory.isPresent()){
            Dormitory foundDormitory=dormitory.get();
            foundDormitory.setName(newDormitory.getName());
            foundDormitory.setGeneral_capacity(newDormitory.getGeneral_capacity());
            dormitoryRepository.save(foundDormitory);
            return foundDormitory;
        }
        else{
            throw new DormitoryNotFoundException("Dormitory could not found by this id.");
        }
    }
    public void updateGeneralCapacity(int generalCapacity, Long dormitoryId){
        Optional<Dormitory> dormitory=dormitoryRepository.findById((dormitoryId));
        if(dormitory.isPresent()){
            Dormitory foundDormitory=dormitory.get();
            foundDormitory.setGeneral_capacity(generalCapacity);
            dormitoryRepository.save(foundDormitory);
        }
    }



    public void deleteById(Long dormitory_id) {
        //dormitoryRepository.deleteById(dormitory_id);
        List<Dormitory> dormitories = dormitoryRepository.findAll();
        if(dormitories.isEmpty()){
            throw new AddressNotFoundException("Dormitory could not found.");

        }
        else{
            dormitoryRepository.deleteById(dormitory_id);
        }
    }

}
