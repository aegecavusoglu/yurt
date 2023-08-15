package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Room;
import com.example.yurt2.Entities.StudentContract;
import com.example.yurt2.Services.StudentContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")

public class StudentContractController {
    StudentContractService studentContractService;

    public StudentContractController(StudentContractService studentContractService) {
        this.studentContractService = studentContractService;
    }
    @GetMapping
    public List<StudentContract> getAllContracts(){
        return studentContractService.getAllContracts();
    }
    @GetMapping("/{studentId}")
    public StudentContract getOneContract(@PathVariable Long studentId){
        return studentContractService.getOneContractByStudentId(studentId);
    }
    @PostMapping("/{create}")
    public StudentContract createOneContract(@RequestBody StudentContract newStudentContract){
        return studentContractService.createOneContract(newStudentContract);
    }
    @PutMapping("/update/{studentId}")
    public StudentContract updateOneContract(@PathVariable Long studentId, @RequestBody StudentContract newStudentContract) {
        return studentContractService.updateOneContract(studentId, newStudentContract);
    }
    @DeleteMapping("/delete/{studentId}")
    public void deleteOneContract(@PathVariable Long studentId){
        studentContractService.deleteById(studentId);
    }


}
