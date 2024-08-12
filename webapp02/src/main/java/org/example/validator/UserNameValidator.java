package org.example.validator;

import org.example.api.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.equals", "Username is required");

        String username = ((UserRegistrationDTO) target).getUserName();

        if(!username.contains("_")){
            errors.rejectValue("userName", "userName.invalidString", "String must contain a '_'");
        }
    }
}
