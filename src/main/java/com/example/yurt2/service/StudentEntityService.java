package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.Student;
import com.example.yurt2.exception.RoomNotFoundException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.repository.StudentRepository;
import com.example.yurt2.request.StudentCreateRequest;
import com.example.yurt2.validator.IdentityNumberValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentEntityService {
    private StudentRepository studentRepository;

    public StudentEntityService(StudentRepository studentRepository,IdentityNumberValidator identityNumberValidator){
        this.studentRepository=studentRepository;
    }
    public List<Student> getAllStudents(){
        //return studentRepository.findAll();
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            throw new StudentNotFoundException("Students could not found");

        }
        else{
            return students;
        }
    }
    public Student getOneStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()-> new StudentNotFoundException("No students can be found by this id."));
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
            throw new StudentNotFoundException("No students can be found by this id.");
        }
    }

    public List<Student> getStudentByName(String name) {
        //return studentRepository.getStudentByName(name);
        List<Student> students = studentRepository.getStudentByName(name);
        if(students.isEmpty()){
            throw new StudentNotFoundException("There are no students matching with this name.");
        }
        else{
            return students;
        }

    }

    public List<String> getSchoolListWithStudentCount() {
        return studentRepository.getSchoolListWithStudentCount();
    }

    public List<Student> getStudentByNameAndSurname(String name, String surname) {
        List<Student> students = studentRepository.findStudentByNameAndSurname(name, surname);
        if(students.isEmpty()){
            throw new StudentNotFoundException("Student not matching with this name and surname.");

        }
        else{
            return students;
        }
        //return studentRepository.findStudentByNameAndSurname(name,surname);
    }

    public List<Student> getStudentBySchoolName(String schoolName) {
        //return studentRepository.findStudentBySchoolName(schoolName);
        List<Student> students = studentRepository.findStudentBySchoolName(schoolName);
        if(students.isEmpty()){
            throw new StudentNotFoundException("There are no students that is a member of this school.");

        }
        else{
            return students;
        }
    }
}
