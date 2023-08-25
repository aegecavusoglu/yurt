package com.example.yurt2.service;

import com.example.yurt2.entity.StudentContract;
import com.example.yurt2.request.StudentContractCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentContractService {
    StudentContractEntityService studentContractEntityService;

    public StudentContractService(StudentContractEntityService studentContractEntityService) {
        this.studentContractEntityService = studentContractEntityService;
    }

    public List<StudentContract> getAllContracts() {
        return studentContractEntityService.getAllContracts();
    }

    public StudentContract getOneContractByStudentId(Long studentId) {
        return studentContractEntityService.getOneContractByStudentId(studentId);
    }

    public StudentContract createOneContract(StudentContractCreateRequest studentContractCreateRequest) {
        return studentContractEntityService.createOneContract(studentContractCreateRequest);
    }

    public StudentContract updateOneContract(Long studentId, StudentContract newStudentContract) {
        return studentContractEntityService.updateOneContract(studentId,newStudentContract);
    }

    public void deleteById(Long identityNumber) {
        studentContractEntityService.deleteById(identityNumber);
    }
    public int findActiveStudentsNumberByRoomId(Long roomId){
        return studentContractEntityService.findActiveStudentsNumberByRoomId(roomId);
    }
}
