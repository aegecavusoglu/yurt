package com.example.yurt2.service;

import com.example.yurt2.entity.Room;
import com.example.yurt2.entity.StudentContract;
import com.example.yurt2.exception.ContractNotFoundException;
import com.example.yurt2.exception.RoomNotFoundException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.repository.StudentContractRepository;
import com.example.yurt2.request.StudentContractCreateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class StudentContractEntityService {
    StudentContractRepository studentContractRepository;

    public StudentContractEntityService(StudentContractRepository studentContractRepository) {
        this.studentContractRepository = studentContractRepository;
    }

    public List<StudentContract> getAllContracts() {

        //return studentContractRepository.findAll();
        List<StudentContract> studentContracts = studentContractRepository.findAll();
        if(studentContracts.isEmpty()){
            throw new ContractNotFoundException("Contracts could not found");

        }
        else{
            return studentContracts;
        }
    }

    public StudentContract getOneContractByStudentId(Long studentId) {
        return studentContractRepository.findByStudentIdAndIsValidIsTrue(studentId).orElseThrow(()->new ContractNotFoundException("There are no contracts available for this student."));
    }

    public StudentContract createOneContract(StudentContractCreateRequest studentContractCreateRequest) {
        StudentContract studentContract = new StudentContract();
        if (getOneContractByStudentId(studentContractCreateRequest.getStudentId())!=null){
            StudentContract oldStudentContract=getOneContractByStudentId(studentContractCreateRequest.getStudentId());
            oldStudentContract.setIsValid(false);
        }
        studentContract.setStudentId(studentContractCreateRequest.getStudentId());
        Date today = new Date();
        LocalDate contractEndDate = LocalDate.now();
        contractEndDate=contractEndDate.plusMonths(6);
        if (studentContractCreateRequest.getContractStartDate()!=null){
            studentContract.setContractStartDate(studentContractCreateRequest.getContractStartDate());
        }
        else {
            studentContract.setContractStartDate(today);
        }
        if (studentContractCreateRequest.getContractEndDate()!=null){
            studentContract.setContractEndDate(studentContractCreateRequest.getContractEndDate());
        }
        else {
            studentContract.setContractEndDate(contractEndDate);
        }
        studentContract.setIsValid(true);
        return studentContractRepository.save(studentContract);
    }

    public StudentContract updateOneContract(Long studentId, StudentContract newStudentContract) {
        Optional<StudentContract> studentContract=studentContractRepository.findByStudentIdAndIsValidIsTrue(studentId);
        if(studentContract.isPresent()){
            StudentContract foundContract=studentContract.get();
            foundContract.setContractStartDate(newStudentContract.getContractStartDate());
            foundContract.setContractEndDate(newStudentContract.getContractEndDate());
            foundContract.setIsValid(newStudentContract.isValid());
            studentContractRepository.save(foundContract);
            return foundContract;
        }
        else{
            throw new ContractNotFoundException("There are no contracts available for this student.");
        }

    }

    public void deleteById(Long identityNumber) {
        studentContractRepository.deleteById(identityNumber);

    }
    public int findActiveStudentsNumberByRoomId(Long roomId){
        return studentContractRepository.findActiveStudentsNumberByRoomId(roomId);
    }
}
