package com.example.yurt2.service;

import com.example.yurt2.entity.StudentContract;
import com.example.yurt2.repository.StudentContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentContractEntityService {
    StudentContractRepository studentContractRepository;

    public StudentContractEntityService(StudentContractRepository studentContractRepository) {
        this.studentContractRepository = studentContractRepository;
    }

    public List<StudentContract> getAllContracts() {
        return studentContractRepository.findAll();
    }

    public StudentContract getOneContractByStudentId(Long studentId) {
        return studentContractRepository.findByStudentId(studentId).orElse(null);
    }

    public StudentContract createOneContract(StudentContract newStudentContract) {
        return studentContractRepository.save(newStudentContract);
    }

    public StudentContract updateOneContract(Long studentId, StudentContract newStudentContract) {
        Optional<StudentContract> studentContract=studentContractRepository.findByStudentId((studentId));
        if(studentContract.isPresent()){
            StudentContract foundContract=studentContract.get();
            foundContract.setContractStartDate(newStudentContract.getContractStartDate());
            foundContract.setContractEndDate(newStudentContract.getContractEndDate());
            foundContract.setValid(newStudentContract.isValid());
            studentContractRepository.save(foundContract);
            return foundContract;
        }
        else{
            return null;
        }

    }

    public void deleteById(Long identityNumber) {
        studentContractRepository.deleteById(identityNumber);
    }
    public int findActiveStudentsNumberByRoomId(Long roomId){
        return studentContractRepository.findActiveStudentsNumberByRoomId(roomId);
    }
}
