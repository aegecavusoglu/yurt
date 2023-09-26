package com.example.yurt2.controller;


import com.example.yurt2.entity.Dormitory;
import com.example.yurt2.entity.RoomFeature;
import com.example.yurt2.entity.Student;
import com.example.yurt2.service.DormitoryEntityService;
import com.example.yurt2.service.DormitoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {
    DormitoryEntityService dormitoryEntityService;
    DormitoryService dormitoryService;

    public DormitoryController(DormitoryEntityService dormitoryEntityService,DormitoryService dormitoryService) {
        this.dormitoryEntityService = dormitoryEntityService;
        this.dormitoryService = dormitoryService;
    }
    @GetMapping
    public List<Dormitory> getAllDormitories(){
        return dormitoryEntityService.getAllDormitories();
    }
    @GetMapping("/{dormitoryId}")
    public Dormitory getOneDormitory(@PathVariable Long dormitoryId){
        return dormitoryEntityService.getOneDormitory(dormitoryId);
    }
    @GetMapping("/capacity/{dormitoryId}")
    public int getCapacity(@PathVariable Long dormitoryId){
        return dormitoryService.getCapacity(dormitoryId);
    }
    @PostMapping("/create")
    public Dormitory createOneDormitory(@RequestBody Dormitory new_dormitory){
        return dormitoryEntityService.createOneDormitory(new_dormitory);
    }
    @PutMapping("/update/{dormitory_id}")
    public Dormitory updateOneDormitory(@PathVariable Long dormitory_id,@RequestBody Dormitory new_dormitory){
        return dormitoryEntityService.updateOneDormitory(dormitory_id,new_dormitory);
    }

    @DeleteMapping("/{dormitory_id}")
    public void deleteOneDormitory(@PathVariable Long dormitory_id){
        dormitoryEntityService.deleteById(dormitory_id);
    }

    @GetMapping("/getFreeCapacity/{dormitoryId}")
    public int getFreeCapacity(@PathVariable Long dormitoryId){
        return dormitoryService.getFreeCapacity(dormitoryId);
    }
    @GetMapping("/getFreeRooms")
    public List<RoomFeature> getFreeRooms(){
        return dormitoryService.getFreeRooms();

    }
    @GetMapping("/dormitoryEstimatedOneMonthIncome")
    public int calculateOneMonthIncomes(){
        return dormitoryService.calculateOneMonthIncomes();
    }

    @GetMapping("/Schools")
    public List<String> getSchoolList(){
        return dormitoryService.getSchoolList();
    }





}
