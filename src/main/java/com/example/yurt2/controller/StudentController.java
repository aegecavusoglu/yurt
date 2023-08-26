package com.example.yurt2.controller;

import com.example.yurt2.entity.Student;
import com.example.yurt2.request.AddressCreateRequest;
import com.example.yurt2.request.StudentCreateRequest;
import com.example.yurt2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {this.studentService = studentService; }
    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        return studentService.createStudent(studentCreateRequest);
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
    @GetMapping("/getStudentByIdentityNumber/{identityNumber}")
    public Optional<Student> getOneStudentByIdentityNumber(@PathVariable String identityNumber){
        return studentService.getOneStudentByIdentityNumber(identityNumber);
    }
    @PutMapping("/changeStudentAddress/{studentId}")
    public void changeStudentAddress(@PathVariable Long studentId, @RequestBody AddressCreateRequest addressCreateRequest){
        studentService.changeStudentAddress(studentId,addressCreateRequest);
    }

    @GetMapping("/getStudent/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/getStudentByNameAndSurname/{name}/{surname}")
    public List<Student> getStudentByNameAndSurname(@PathVariable String name,@PathVariable String surname){
        return studentService.getStudentByNameAndSurname(name,surname);
    }


}
