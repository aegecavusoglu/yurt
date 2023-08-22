package com.example.yurt2.service;

import com.example.yurt2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentEntityService studentEntityService;

    public StudentService(StudentEntityService studentEntityService) {
        this.studentEntityService = studentEntityService;
    }
    public List<Student> getAllStudents(){
        return studentEntityService.getAllStudents();
    }
    public Student getOneStudentById(Long studentId){
        return studentEntityService.getOneStudentById(studentId);
    }
    public Student createStudent(Student newStudent){
        return studentEntityService.createStudent(newStudent);
    }
    public Optional<Student> getOneStudentByIdentityNumber(String identityNumber){
        return studentEntityService.getOneStudentByIdentityNumber(identityNumber);
    }
    public Student updateStudent(Long studentId, Student newStudent){
        return studentEntityService.updateStudent(studentId,newStudent);
    }
}
