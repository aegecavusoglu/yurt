package com.example.yurt2.Services;

import com.example.yurt2.Entities.Dormitory;
import com.example.yurt2.Entities.Student;
import com.example.yurt2.Repos.StudentRepository;
import com.example.yurt2.Requests.DormitoryCreateRequest;
import com.example.yurt2.Requests.StudentCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository student_repository;
    public StudentService(StudentRepository studentRepository){
        this.student_repository=studentRepository;
    }
    public List<Student> getAllStudents(){return student_repository.findAll();}
    public Student getOneStudentById(Long student_id){
        return student_repository.findById(student_id).orElse(null);
    }
    public Student createStudent(StudentCreateRequest new_student_request){
        Student toSave = new Student();
        toSave.setPhone_number(new_student_request.getPhoneNumber());
        toSave.setName(new_student_request.getName());
        toSave.setSurname(new_student_request.getSurname());
        toSave.setSchool(new_student_request.getSchool());
        toSave.setIdentity_number(new_student_request.getIdentityNumber());
        toSave.setId(new_student_request.getId());
        toSave.setFamily_number(new_student_request.getFamilyNumber());
        toSave.setAdress_id(new_student_request.getAddressId());
        return student_repository.save(toSave);
    }
    public Student updateStudent(Long studentId,Student newStudent){
        Optional<Student> student = student_repository.findById(studentId);
        if(student.isPresent()){
            Student found_student=student.get();
            found_student.setName(newStudent.getName());
            found_student.setSurname(newStudent.getSurname());
            found_student.setSchool(newStudent.getSchool());
            found_student.setAdress_id(newStudent.getAdress_id());
            found_student.setFamily_number(newStudent.getFamily_number());
            found_student.setPhone_number(newStudent.getPhone_number());
            found_student.setIdentity_number(newStudent.getIdentity_number());
            student_repository.save(found_student);
            return found_student;
        }
        else{
            return null;
        }
    }
}
