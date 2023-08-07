package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Requests.DormitoryCreateRequest;
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
    public List<Dormitory> getAllDormitories(@RequestParam Optional<Long> adminId){
        return dormitoryService.getAllDormitories(adminId);
    }
    @PostMapping
    public Dormitory createOneDormitory(@RequestBody DormitoryCreateRequest newDormitoryRequest){
        return dormitoryService.createOneDormitory(newDormitoryRequest);
    }
    @GetMapping("/{dormitoryId}")
    public Dormitory getOneDormitory(@PathVariable Long dormitoryId){
        return dormitoryService.getOneDormitoryById(dormitoryId);
    }


}
