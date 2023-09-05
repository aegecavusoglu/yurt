package com.example.yurt2.validator;

import com.example.yurt2.exception.InvalidStringException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.request.StudentCreateRequest;
import org.springframework.stereotype.Component;

@Component

public class SurnameValidator {
    public SurnameValidator() {
    }

    public boolean validate(StudentCreateRequest studentCreateRequest){
        if ( studentCreateRequest == null){
            throw new StudentNotFoundException("student is null");
        }
        for (int i=0;i < studentCreateRequest.getSurname().length(); ++i)
            if(Character.isDigit(studentCreateRequest.getSurname().charAt(i))){
                throw new InvalidStringException("Surname cannot contain digits.");
            }
        return true;
    }
}
