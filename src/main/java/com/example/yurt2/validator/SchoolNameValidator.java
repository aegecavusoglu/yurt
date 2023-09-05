package com.example.yurt2.validator;

import com.example.yurt2.exception.InvalidStringException;
import com.example.yurt2.exception.StudentNotFoundException;
import com.example.yurt2.request.StudentCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class SchoolNameValidator {
    public SchoolNameValidator() {
    }

    public boolean validate(StudentCreateRequest studentCreateRequest){
        if ( studentCreateRequest == null){
            throw new StudentNotFoundException("student is null");
        }
        for (int i=0;i < studentCreateRequest.getSchoolName().length(); ++i)
            if(Character.isDigit(studentCreateRequest.getSchoolName().charAt(i))){
                throw new InvalidStringException("SchoolName cannot contain digits.");
            }
        return true;
    }
}
