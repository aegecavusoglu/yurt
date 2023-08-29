package com.example.yurt2.service;

import com.example.yurt2.entity.Address;
import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.repository.AddressRepository;
import com.example.yurt2.request.AddressCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressEntityService {
    AddressRepository addressRepository;

    public AddressEntityService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddress() {
        //return addressRepository.findAll();
        List<Address> address = addressRepository.findAll();
        if(address.isEmpty()){
            throw new AddressNotFoundException("Adress could not found.");

        }
        else{
            return address;
        }
    }
    public Optional<Address> getOneAddressById(Long addressId){
        //return addressRepository.findById(addressId);
        Optional<Address> address = addressRepository.findById(addressId);
        if(address.isPresent()){
            return addressRepository.findById(addressId);
        }
        else{
            throw new AddressNotFoundException("Address with id:" + addressId +" is not found.");
        }

    }
    public Address createAddress(AddressCreateRequest addressCreateRequest){
        Address newAddress = new Address();
        newAddress.setAddressType(addressCreateRequest.getAddressType());
        newAddress.setAddressDescription(addressCreateRequest.getAddressDescription());
        newAddress.setCity(addressCreateRequest.getCity());
        newAddress.setCountry(addressCreateRequest.getCountry());
        newAddress.setStreet(addressCreateRequest.getStreet());
        return addressRepository.save(newAddress);
    }
    public Address updateAddress(Long addressId,Address newAddress){
        Optional<Address> address = addressRepository.findById(addressId);
        if(address.isPresent()){
            Address foundAddress=address.get();
            foundAddress.setAddressType(newAddress.getAddressType());
            foundAddress.setCity(newAddress.getCity());
            foundAddress.setCountry(newAddress.getCountry());
            foundAddress.setStreet(newAddress.getStreet());
            addressRepository.save(foundAddress);
            return foundAddress;
        }
        else {
            throw new AddressNotFoundException("Address with id:" + addressId +" is not found.");
        }
    }
    public void deleteById(Long addressId){
        //addressRepository.deleteById(addressId);
        Optional<Address> address = addressRepository.findById(addressId);
        if(address.isPresent()){
            addressRepository.deleteById(addressId);
        }
        else{
            throw new AddressNotFoundException("Address with id:" + addressId +" is not found.");
        }
    }
}
