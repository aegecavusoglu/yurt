package com.example.yurt2.controller;

import com.example.yurt2.entity.StudentContract;
import com.example.yurt2.service.StudentContractEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")

public class StudentContractController {
    StudentContractEntityService studentContractEntityService;

    public StudentContractController(StudentContractEntityService studentContractEntityService) {
        this.studentContractEntityService = studentContractEntityService;
    }
    @GetMapping
    public List<StudentContract> getAllContracts(){
        return studentContractEntityService.getAllContracts();
    }
    @GetMapping("/{studentId}")
    public StudentContract getOneContract(@PathVariable Long studentId){
        return studentContractEntityService.getOneContractByStudentId(studentId);
    }
    @PostMapping("/{create}")
    public StudentContract createOneContract(@RequestBody StudentContract newStudentContract){
        return studentContractEntityService.createOneContract(newStudentContract);
    }
    @PutMapping("/update/{studentId}")
    public StudentContract updateOneContract(@PathVariable Long studentId, @RequestBody StudentContract newStudentContract) {
        return studentContractEntityService.updateOneContract(studentId, newStudentContract);
    }
    @DeleteMapping("/delete/{studentId}")
    public void deleteOneContract(@PathVariable Long studentId){
        studentContractEntityService.deleteById(studentId);
    }


}
