package com.example.yurt2.validator;

import com.example.yurt2.exception.AddressNotFoundException;
import com.example.yurt2.exception.InvalidAddressTypeException;
import com.example.yurt2.exception.InvalidStringException;
import com.example.yurt2.request.AddressCreateRequest;
import org.springframework.stereotype.Component;

@Component

public class AddressValidator {
    public AddressValidator() {
    }
    public boolean validate(AddressCreateRequest addressCreateRequest){
        if ( addressCreateRequest == null){
            throw new AddressNotFoundException("address is null");
        }

        for (int i=0; i <addressCreateRequest.getCity().length();++i)
            if(Character.isDigit(addressCreateRequest.getCity().charAt(i))){
                throw new InvalidStringException("City names cannot contain digits.");
            }
        for (int i=0;i<addressCreateRequest.getCountry().length();++i)
            if(Character.isDigit(addressCreateRequest.getCountry().charAt(i))){
                throw new InvalidStringException("Country names cannot contain digits.");
            }
        if (addressCreateRequest.getAddressType().equals("dormitory")){
            return true;
        }
        else if (addressCreateRequest.getAddressType().equals("student")) {
            return true;
        }
        else
            throw new InvalidAddressTypeException("Address type must be one of the following: Student or Dormitory.");


    }
}
