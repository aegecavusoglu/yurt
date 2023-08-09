package com.example.yurt2.Services;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Repos.DormitoryRepository;
import com.example.yurt2.Requests.DormitoryCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DormitoryService {
    private DormitoryRepository dormitory_repository;

    public DormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitory_repository = dormitoryRepository;
    }

    public Dormitory getDormitory(Long dormitoryId) {
        return dormitory_repository.findById(dormitoryId).orElse(null);
    }

    public Dormitory createOneDormitory(DormitoryCreateRequest newDormitoryRequest) {
        Dormitory toSave=new Dormitory();
        toSave.setId(newDormitoryRequest.getId());
        toSave.setName(newDormitoryRequest.getName());
        toSave.setAddress_id(newDormitoryRequest.getAddress_id());
        return dormitory_repository.save(toSave);

    }
}
