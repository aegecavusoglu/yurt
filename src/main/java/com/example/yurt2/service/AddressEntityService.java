package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressEntityService {
    AddressRepository addressRepository;

    public AddressEntityService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddress()
    {return addressRepository.findAll();}
    public Optional<Address> getOneAddressById(Long addressId){
        return addressRepository.findById(addressId);
    }
    public Address createAddress(Address newAddress){
        return addressRepository.save(newAddress);
    }
    public Address updateAddress(Long addressId,Address newAddress){
        Optional<Address> address = addressRepository.findById(addressId);
        if(address.isPresent()){
            Address foundAddress=address.get();
            foundAddress.setAddress_type(newAddress.getAddress_type());
            foundAddress.setCity(newAddress.getCity());
            foundAddress.setCountry(newAddress.getCountry());
            foundAddress.setStreet(newAddress.getStreet());
            addressRepository.save(foundAddress);
            return foundAddress;
        }
        else {
            return null;
        }
    }
    public void deleteById(Long addressId){
        addressRepository.deleteById(addressId);
    }
}
