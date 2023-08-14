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
    @PostMapping
    public Dormitory createOneDormitory(Dormitory new_dormitory){
        return dormitoryService.createOneDormitory(new_dormitory);
    }
    @GetMapping("/{dormitoryId}")
    public Dormitory getDormitory(@PathVariable Long dormitoryId){
        return dormitoryService.getDormitory(dormitoryId);
    }


}
