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
    public Optional<Student> getOneStudentByIdentityNumber(String identityNumber){
        return studentRepository.findByIdentityNumber(identityNumber);
    }
    public Student updateStudent(Long studentId,Student newStudent){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            Student foundStudent=student.get();
            foundStudent.setName(newStudent.getName());
            foundStudent.setSurname(newStudent.getSurname());
            foundStudent.setSchoolName(newStudent.getSchoolName());
            foundStudent.setAddressId(newStudent.getAddressId());
            foundStudent.setFamilyNumber(newStudent.getFamilyNumber());
            foundStudent.setPhoneNumber(newStudent.getPhoneNumber());
            foundStudent.setIdentityNumber(newStudent.getIdentityNumber());
            studentRepository.save(foundStudent);
            return foundStudent;
        }
        else{
            return null;
        }
    }



}
