package com.example.yurt2.controller;

import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.service.StudentRoomRelationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentRoomRelation")
public class StudentRoomRelationController {
    StudentRoomRelationService studentRoomRelationService;


    public StudentRoomRelationController(StudentRoomRelationService studentRoomRelationService) {
        this.studentRoomRelationService = studentRoomRelationService;
    }
    @GetMapping("/getAllRecords")
    public List<StudentRoomRelation> getAllStudentRoomRelation(){
        return studentRoomRelationService.getAllStudentRoomRelation();
    }

    @GetMapping("/{studentRoomRelationId}")
    public StudentRoomRelation getOneStudentRoomRelation(@PathVariable Long studentRoomRelationId){
        return studentRoomRelationService.getOneStudentRoomRelationById(studentRoomRelationId);
    }
    @GetMapping("/getOneStudentRecords/{studentIdentityNumber}")
    public List<StudentRoomRelation> getAllStudentRoomRelationByStudentIdentityNumber(@PathVariable String studentIdentityNumber){
        return studentRoomRelationService.getAllStudentRoomRelationByStudentIdentityNumber(studentIdentityNumber);
    }

    @PostMapping("/create")
    public StudentRoomRelation createOneStudentRoomRelation(@RequestBody StudentRoomRelation newStudentRoomRelation){
        return studentRoomRelationService.createOneStudentRoomRelation(newStudentRoomRelation);}

    @GetMapping("/getOneRoomRecords/{roomNumber}")
    public List<StudentRoomRelation> getAllRelationsForOneRoomByRoomNumber(@PathVariable Long roomNumber){
        return studentRoomRelationService.getAllRelationsForOneRoomByRoomNumber(roomNumber);
    }


}
