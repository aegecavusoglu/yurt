package com.example.yurt2.service;

import com.example.yurt2.entity.Student;
import com.example.yurt2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentEntityService {
    private StudentRepository studentRepository;
    public StudentEntityService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getAllStudents(){return studentRepository.findAll();}
    public Student getOneStudentById(Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    public Student createStudent(Student newStudent){
        return studentRepository.save(newStudent);
    }
    public Student updateStudent(Long studentId,Student newStudent){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            Student foundStudent=student.get();
            foundStudent.setName(newStudent.getName());
            foundStudent.setSurname(newStudent.getSurname());
            foundStudent.setSchool_name(newStudent.getSchool_name());
            foundStudent.setAddress_id(newStudent.getAddress_id());
            foundStudent.setFamily_number(newStudent.getFamily_number());
            foundStudent.setPhone_number(newStudent.getPhone_number());
            foundStudent.setIdentity_number(newStudent.getIdentity_number());
            studentRepository.save(foundStudent);
            return foundStudent;
        }
        else{
            return null;
        }
    }



}
