package com.example.yurt2.validator;

import com.example.yurt2.exception.InvalidIdentityNumberException;
import com.example.yurt2.exception.InvalidPhoneNumberException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.request.StudentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidator {
    public PhoneNumberValidator() {
    }
    public boolean validate(StudentCreateRequest studentCreateRequest){
        if ( studentCreateRequest == null){
            throw new StudentNotFoundException("student is null");
        }

        if(studentCreateRequest.getPhoneNumber().length()==11 && studentCreateRequest.getFamilyNumber().length()==11){
            return true;
        }
        else{
            throw new InvalidPhoneNumberException("Invalid Phone Number.");
        }
    }
}
