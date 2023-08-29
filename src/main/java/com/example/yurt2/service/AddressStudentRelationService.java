package com.example.yurt2.service;

import com.example.yurt2.entity.AddressStudentRelation;
import com.example.yurt2.entity.Student;
import com.example.yurt2.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressStudentRelationService {
    AddressStudentRelationEntityService addressStudentRelationEntityService;
    StudentEntityService studentEntityService;

    public AddressStudentRelationService(AddressStudentRelationEntityService addressStudentRelationEntityService, StudentEntityService studentEntityService) {
        this.addressStudentRelationEntityService = addressStudentRelationEntityService;
        this.studentEntityService = studentEntityService;
    }
    public List<AddressStudentRelation> getAllAddressStudentRelation()
    {return addressStudentRelationEntityService.getAllAddressStudentRelation();}
    public Optional<AddressStudentRelation> getOneAddressStudentRelationById(Long addressStudentRelationId){
        return addressStudentRelationEntityService.getOneAddressStudentRelationById(addressStudentRelationId);
    }
    public AddressStudentRelation createAddressStudentRelation(AddressStudentRelation addressStudentRelation){
        return addressStudentRelationEntityService.createAddressStudentRelation(addressStudentRelation);
    }
    public AddressStudentRelation getOneAddressStudentRelationByCurrentAddressId(Long currentAddressId){
        return addressStudentRelationEntityService.getOneAddressStudentRelationByCurrentAddressId(currentAddressId);
    }
    public boolean isThereSuchAnAddressStudentRelationByStudentId(Long studentId){
        if(addressStudentRelationEntityService.getOneAddressStudentRelationByStudentId(studentId).isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    public List<AddressStudentRelation> getAllAddressStudentRelationByStudentIdentityNumber(String identityNumber) {
        Student student = studentEntityService.getOneStudentByIdentityNumber(identityNumber).get();
        if(student==null){
            throw new StudentNotFoundException("Student with identityNumber:" + identityNumber +" could not found.");
        }
        else{
            return addressStudentRelationEntityService.getOneAddressStudentRelationByStudentId(student.getId());
        }

        //return addressStudentRelationEntityService.getOneAddressStudentRelationByStudentId(student.getId());
    }
}
