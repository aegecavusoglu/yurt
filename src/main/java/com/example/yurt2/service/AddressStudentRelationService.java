package com.example.yurt2.service;

import com.example.yurt2.entity.AddressStudentRelation;
import com.example.yurt2.entity.Student;
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

    public List<AddressStudentRelation> getAllAddressStudentRelationByStudentIdentityNumber(String studentIdentityNumber) {
        Student student = studentEntityService.getOneStudentByIdentityNumber(studentIdentityNumber).get();
        return addressStudentRelationEntityService.getOneAddressStudentRelationByStudentId(student.getId());
    }
}
