package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Address;
import com.example.yurt2.Services.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping
    public List<Address> getAllAddress(){
       return addressService.getAllAddress();
    }
    @GetMapping("/{addressId}")
    public Optional<Address> getOneAddressById(@PathVariable Long addressId){
        return addressService.getOneAddressById(addressId);
    }
    @PostMapping("/create")
    public Address createAddress(@RequestBody Address newAddress){
       return addressService.createAddress(newAddress);
    }
    @PutMapping("/update/{addressId}")
    public Address updateAddress (@PathVariable Long addressId,@RequestBody Address newAddress){
        return addressService.updateAddress(addressId,newAddress);
    }
    @DeleteMapping("/delete/{addressId}")
    public void deleteById(@PathVariable Long addressId){
        addressService.deleteById(addressId);
    }
}
