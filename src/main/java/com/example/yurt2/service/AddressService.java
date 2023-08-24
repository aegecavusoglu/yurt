package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.request.AddressCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressEntityService addressEntityService;

    public AddressService(AddressEntityService addressEntityService) {
        this.addressEntityService = addressEntityService;
    }

    public List<Address> getAllAddress()
    {return addressEntityService.getAllAddress();}
    public Optional<Address> getOneAddressById(Long addressId){
        return addressEntityService.getOneAddressById(addressId);
    }
    public Address createAddress(AddressCreateRequest addressCreateRequest){
        return addressEntityService.createAddress(addressCreateRequest);
    }
    public Address updateAddress(Long addressId,Address newAddress){
        return addressEntityService.updateAddress(addressId,newAddress);
    }
    public void deleteById(Long addressId){
        addressEntityService.deleteById(addressId);
    }
}
