package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Services.DormitoryEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {
    DormitoryEntityService dormitoryEntityService;

    public DormitoryController(DormitoryEntityService dormitoryEntityService) {
        this.dormitoryEntityService = dormitoryEntityService;
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
        return dormitoryEntityService.getCapacity(dormitoryId);
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



}
