package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.request.AddressCreateRequest;
import com.example.yurt2.validator.AddressValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressEntityService addressEntityService;
    AddressValidator addressValidator;

    public AddressService(AddressEntityService addressEntityService,AddressValidator addressValidator) {
        this.addressEntityService = addressEntityService;
        this.addressValidator=addressValidator;
    }

    public List<Address> getAllAddress()
    {return addressEntityService.getAllAddress();}
    public Optional<Address> getOneAddressById(Long addressId){
        return addressEntityService.getOneAddressById(addressId);
    }
    public Address createAddress(AddressCreateRequest addressCreateRequest){
        addressValidator.validate(addressCreateRequest);
        return addressEntityService.createAddress(addressCreateRequest);
    }
    public Address updateAddress(Long addressId,Address newAddress){
        return addressEntityService.updateAddress(addressId,newAddress);
    }
    public void deleteById(Long addressId){
        addressEntityService.deleteById(addressId);
    }
}
