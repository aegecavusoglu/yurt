package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.entity.AddressStudentRelation;
import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.repository.AddressStudentRelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressStudentRelationEntityService {
    AddressStudentRelationRepository addressStudentRelationRepository;

    public AddressStudentRelationEntityService(AddressStudentRelationRepository addressStudentRelationRepository) {
        this.addressStudentRelationRepository = addressStudentRelationRepository;
    }
    public List<AddressStudentRelation> getAllAddressStudentRelation() {
        //return addressStudentRelationRepository.findAll();}
        List<AddressStudentRelation> addressStudentRelation = addressStudentRelationRepository.findAll();
        if (addressStudentRelation.isEmpty()) {
            throw new AddressNotFoundException("Relation could not found.");

        } else {
            return addressStudentRelation;
        }
    }

    public Optional<AddressStudentRelation> getOneAddressStudentRelationById(Long addressStudentRelationId){
        //return addressStudentRelationRepository.findById(addressStudentRelationId);
        List<AddressStudentRelation> addressStudentRelation = addressStudentRelationRepository.findAll();
        if (addressStudentRelation.isEmpty()) {
            throw new AddressNotFoundException("Relation could not found.");

        } else {
            return addressStudentRelationRepository.findById(addressStudentRelationId);
        }
    }
    public AddressStudentRelation getOneAddressStudentRelationByCurrentAddressId(Long currentAddressId){
        //return addressStudentRelationRepository.findByCurrentAddressId(currentAddressId);
        Optional<AddressStudentRelation> addressStudentRelation = addressStudentRelationRepository.findById(currentAddressId);
        if(addressStudentRelation.isPresent()){
            return addressStudentRelationRepository.findByCurrentAddressId(currentAddressId);
        }
        else{
            throw new AddressNotFoundException("Address with id:" + currentAddressId +" is not found.");
        }
    }
    public AddressStudentRelation createAddressStudentRelation(AddressStudentRelation addressStudentRelation){
        return addressStudentRelationRepository.save(addressStudentRelation);
    }

    public List<AddressStudentRelation> getOneAddressStudentRelationByStudentId(Long studentId) {
        //return addressStudentRelationRepository.findByStudentId(studentId);
        List<AddressStudentRelation> addressStudentRelation = addressStudentRelationRepository.findByStudentId(studentId);
        if(addressStudentRelation.isEmpty()){
            throw new StudentNotFoundException("Student with id:" + studentId +" could not found.");
        }
        else{

            return addressStudentRelationRepository.findByStudentId(studentId);
        }

    }

}
