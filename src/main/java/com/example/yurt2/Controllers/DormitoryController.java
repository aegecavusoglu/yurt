package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Services.DormitoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dormitories")
public class DormitoryController {
    DormitoryService dormitoryService;

    public DormitoryController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }
    @GetMapping
    public List<Dormitory> getAllDormitories(){
        return dormitoryService.getAllDormitories();
    }
    @GetMapping("/{dormitoryId}")
    public Dormitory getOneDormitory(@PathVariable Long dormitory_id){
        return dormitoryService.getOneDormitory(dormitory_id);
    }
    @PostMapping
    public Dormitory createOneDormitory(Dormitory new_dormitory){
        return dormitoryService.createOneDormitory(new_dormitory);
    }
    @PutMapping("/{dormitory_id}")
    public Dormitory updateOneDormitory(@PathVariable Long dormitory_id,@RequestBody Dormitory new_dormitory){
        return dormitoryService.updateOneDormitory(dormitory_id,new_dormitory);
    }

    @DeleteMapping("/{dormitory_id}")
    public void deleteOneDormitory(@PathVariable Long dormitory_id){
        dormitoryService.deleteById(dormitory_id);
    }



}
