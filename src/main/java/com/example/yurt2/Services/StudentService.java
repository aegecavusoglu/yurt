package com.example.yurt2.Services;

import com.example.yurt2.Entities.Student;
import com.example.yurt2.Repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getAllStudents(){return studentRepository.findAll();}
    public Student getOneStudentById(Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(Long studentId,Student newStudent){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            Student foundStudent=student.get();
            foundStudent.setName(newStudent.getName());
            foundStudent.setSurname(newStudent.getSurname());
            foundStudent.setRoom(newStudent.getRoom());
            foundStudent.setSchool(newStudent.getSchool());
            foundStudent.setAdressId(newStudent.getAdressId());
            foundStudent.setFamilyNumber(newStudent.getFamilyNumber());
            foundStudent.setPhone_number(newStudent.getPhone_number());
            foundStudent.setIdentityNumber(newStudent.getIdentityNumber());
            studentRepository.save(foundStudent);
            return foundStudent;
        }
        else{
            return null;
        }
    }
}
