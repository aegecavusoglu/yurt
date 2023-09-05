package com.example.yurt2.validator;

import com.example.yurt2.exception.InvalidStringException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.request.StudentCreateRequest;
import org.springframework.stereotype.Component;


@Component
public class NameValidator {
    public NameValidator() {
    }

    public boolean validate(StudentCreateRequest studentCreateRequest){
        if ( studentCreateRequest == null){
            throw new StudentNotFoundException("student is null");
        }
        for (int i=0;i < studentCreateRequest.getName().length(); ++i)
            if(Character.isDigit(studentCreateRequest.getName().charAt(i))){
                throw new InvalidStringException("Name cannot contain digits.");
            }
        return true;
    }
}
