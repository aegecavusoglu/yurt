package com.example.yurt2.controller;

import com.example.yurt2.entity.Student;
import com.example.yurt2.service.StudentEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentEntityService studentEntityService;
    public StudentController(StudentEntityService studentEntityService){this.studentEntityService = studentEntityService; }
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student newStudent){
        return studentEntityService.createStudent(newStudent);
    }
    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable Long studentId){
        return studentEntityService.getOneStudentById(studentId);
    }
    @GetMapping
    public List<Student> gelAllStudent(){
        return studentEntityService.getAllStudents();
    }
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student newStudent){
        return studentEntityService.updateStudent(studentId,newStudent);
    }


}
