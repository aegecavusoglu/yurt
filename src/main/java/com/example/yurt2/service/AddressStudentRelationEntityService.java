package com.example.yurt2.service;

import com.example.yurt2.entity.AddressStudentRelation;
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
    public List<AddressStudentRelation> getAllAddressStudentRelation()
    {return addressStudentRelationRepository.findAll();}
    public Optional<AddressStudentRelation> getOneAddressStudentRelationById(Long addressStudentRelationId){
        return addressStudentRelationRepository.findById(addressStudentRelationId);
    }
    public AddressStudentRelation getOneAddressStudentRelationByCurrentAddressId(Long currentAddressId){
        return addressStudentRelationRepository.findByCurrentAddressId(currentAddressId);
    }
    public AddressStudentRelation createAddressStudentRelation(AddressStudentRelation addressStudentRelation){
        return addressStudentRelationRepository.save(addressStudentRelation);
    }

    public List<AddressStudentRelation> getOneAddressStudentRelationByStudentId(Long studentId) {
        return addressStudentRelationRepository.findByStudentId(studentId);
    }

}
