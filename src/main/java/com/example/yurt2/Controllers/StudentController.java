package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Student;
import com.example.yurt2.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){this.studentService=studentService; }
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student newStudent){
        return studentService.createStudent(newStudent);
    }
    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable Long studentId){
        return studentService.getOneStudentById(studentId);
    }
    @GetMapping
    public List<Student> gelAllStudent(){
        return studentService.getAllStudents();
    }
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student newStudent){
        return studentService.updateStudent(studentId,newStudent);
    }

}
