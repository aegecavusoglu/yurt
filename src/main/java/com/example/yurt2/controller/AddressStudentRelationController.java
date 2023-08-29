package com.example.yurt2.controller;

import com.example.yurt2.entity.AddressStudentRelation;
import com.example.yurt2.service.AddressStudentRelationService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressStudentRelation")
public class AddressStudentRelationController {
    AddressStudentRelationService addressStudentRelationService;

    public AddressStudentRelationController(AddressStudentRelationService addressStudentRelationService) {
        this.addressStudentRelationService = addressStudentRelationService;
    }

    @GetMapping("/getAllAddressStudentRelation")
    public List<AddressStudentRelation> getAllAddressStudentRelation()
    {return addressStudentRelationService.getAllAddressStudentRelation();}
    @GetMapping("/getAddressStudentRelationById")
    public Optional<AddressStudentRelation> getOneAddressStudentRelationById(Long addressStudentRelationId){
        return addressStudentRelationService.getOneAddressStudentRelationById(addressStudentRelationId);
    }
    @GetMapping("/getAddressStudentRelation/{identityNumber}")
    public List<AddressStudentRelation> getAllAddressStudentRelationByStudentIdentityNumber(@PathVariable String identityNumber)
    {return addressStudentRelationService.getAllAddressStudentRelationByStudentIdentityNumber(identityNumber);}

}
