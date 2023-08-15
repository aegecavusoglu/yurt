package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Student;
import com.example.yurt2.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService student_service;
    public StudentController(StudentService student_service){this.student_service=student_service; }
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student new_student){
        return student_service.createStudent(new_student);
    }
    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable Long student_id){
        return student_service.getOneStudentById(student_id);
    }
    @GetMapping
    public List<Student> gelAllStudent(){
        return student_service.getAllStudents();
    }
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable Long student_id, @RequestBody Student new_student){
        return student_service.updateStudent(student_id,new_student);
    }

}
