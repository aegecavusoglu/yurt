package com.example.yurt2.Services;

import com.example.yurt2.Entities.Address;
import com.example.yurt2.Repos.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
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
