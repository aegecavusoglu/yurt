package com.example.yurt2.service;

import com.example.yurt2.entity.Student;
import com.example.yurt2.repository.StudentRepository;
import com.example.yurt2.request.StudentCreateRequest;
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
    public Student createStudent(StudentCreateRequest studentCreateRequest){
        Student newStudent = new Student();
        newStudent.setName(studentCreateRequest.getName());
        newStudent.setFamilyNumber(studentCreateRequest.getFamilyNumber());
        newStudent.setSurname(studentCreateRequest.getSurname());
        newStudent.setAddressId(studentCreateRequest.getAddressId());
        newStudent.setIdentityNumber(studentCreateRequest.getIdentityNumber());
        newStudent.setPhoneNumber(studentCreateRequest.getPhoneNumber());
        newStudent.setSchoolName(studentCreateRequest.getSchoolName());
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

    public List<Student> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);

    }

    public List<String> getSchoolListWithStudentCount() {
        return studentRepository.getSchoolListWithStudentCount();
    }

    public List<Student> getStudentByNameAndSurname(String name, String surname) {
        return studentRepository.findStudentByNameAndSurname(name,surname);
    }
}
