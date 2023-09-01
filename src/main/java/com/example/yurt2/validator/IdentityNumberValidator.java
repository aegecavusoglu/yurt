package com.example.yurt2.validator;

import com.example.yurt2.entity.Student;
import com.example.yurt2.exception.InvalidIdentityNumberException;
import com.example.yurt2.request.StudentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class IdentityNumberValidator {
    public IdentityNumberValidator() {
    }
    public boolean validate(StudentCreateRequest studentCreateRequest){
        if ( studentCreateRequest == null){
            throw new InvalidIdentityNumberException("student is null");
        }

        if(studentCreateRequest.getIdentityNumber().length()==11){
            return true;
        }
        else{
            throw new InvalidIdentityNumberException("Identity Number must contain 11 digits.");
        }
    }
}
