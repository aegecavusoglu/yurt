package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.StudentRoomRelation;
import com.example.yurt2.Services.StudentRoomRelationEntityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stundentroomrelation")
public class StudentRoomRelationController {
    StudentRoomRelationEntityService studentRoomRelationEntityService;


    public StudentRoomRelationController(StudentRoomRelationEntityService studentRoomRelationEntityService) {
        this.studentRoomRelationEntityService = studentRoomRelationEntityService;
    }

    @GetMapping("/{studentId}")
    public StudentRoomRelation getOneStudentRoomRelation(@PathVariable Long studentId){
        return studentRoomRelationEntityService.getOneStudentRoomRelationById(studentId);
    }

    @PostMapping("/create")
    public StudentRoomRelation createOneStudentRoomRelation(@RequestBody StudentRoomRelation newStudentRoomRelation){
        return studentRoomRelationEntityService.createOneStudentRoomRelation(newStudentRoomRelation);}

}
