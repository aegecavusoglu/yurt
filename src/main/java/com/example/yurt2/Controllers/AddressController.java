package com.example.yurt2.Controllers;

import com.example.yurt2.Entities.Address;
import com.example.yurt2.Services.AddressEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    AddressEntityService addressEntityService;

    public AddressController(AddressEntityService addressEntityService) {
        this.addressEntityService = addressEntityService;
    }
    @GetMapping
    public List<Address> getAllAddress(){
       return addressEntityService.getAllAddress();
    }
    @GetMapping("/{addressId}")
    public Optional<Address> getOneAddressById(@PathVariable Long addressId){
        return addressEntityService.getOneAddressById(addressId);
    }
    @PostMapping("/create")
    public Address createAddress(@RequestBody Address newAddress){
       return addressEntityService.createAddress(newAddress);
    }
    @PutMapping("/update/{addressId}")
    public Address updateAddress (@PathVariable Long addressId,@RequestBody Address newAddress){
        return addressEntityService.updateAddress(addressId,newAddress);
    }
    @DeleteMapping("/delete/{addressId}")
    public void deleteById(@PathVariable Long addressId){
        addressEntityService.deleteById(addressId);
    }
}
