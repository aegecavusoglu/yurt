package com.example.yurt2.Services;

import com.example.yurt2.Entities.Admin;
import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Repos.DormitoryRepository;
import com.example.yurt2.Requests.DormitoryCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DormitoryService {
    private DormitoryRepository dormitoryRepository;
    private AdminService adminService;

    public DormitoryService(DormitoryRepository dormitoryRepository,AdminService adminService) {
        this.adminService=adminService;
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Dormitory> getAllDormitories(Optional<Long> adminId) {
        if(adminId.isPresent())
            return dormitoryRepository.findByAdminId(adminId.get());
        return dormitoryRepository.findAll();
    }
    public Dormitory getOneDormitoryById(Long dormitoryId) {
        return dormitoryRepository.findById(dormitoryId).orElse(null);
    }

    public Dormitory createOneDormitory(DormitoryCreateRequest newDormitoryRequest) {
        Admin admin=adminService.getOneAdmin(newDormitoryRequest.getAdminId());
        if(admin==null)
            return null;

        Dormitory toSave=new Dormitory();
        toSave.setId(newDormitoryRequest.getId());
        toSave.setName(newDormitoryRequest.getName());
        toSave.set_valid(newDormitoryRequest.is_valid());
        toSave.setAddress_id(newDormitoryRequest.getAddress_id());
        toSave.setAdmin(admin);
        return dormitoryRepository.save(toSave);

    }
}
