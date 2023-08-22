package com.example.yurt2.controller;

import com.example.yurt2.entity.StudentRoomRelation;
import com.example.yurt2.service.StudentRoomRelationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentRoomRelation")
public class StudentRoomRelationController {
    StudentRoomRelationService studentRoomRelationService;


    public StudentRoomRelationController(StudentRoomRelationService studentRoomRelationService) {
        this.studentRoomRelationService = studentRoomRelationService;
    }

    @GetMapping("/{studentRoomRelationId}")
    public StudentRoomRelation getOneStudentRoomRelation(@PathVariable Long studentRoomRelationId){
        return studentRoomRelationService.getOneStudentRoomRelationById(studentRoomRelationId);
    }

    @PostMapping("/create")
    public StudentRoomRelation createOneStudentRoomRelation(@RequestBody StudentRoomRelation newStudentRoomRelation){
        return studentRoomRelationService.createOneStudentRoomRelation(newStudentRoomRelation);}

}
