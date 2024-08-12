package org.example.validator;

import org.example.api.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CommunicationDTO.email", "email.empty");
        String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
        if (!email.endsWith("seleniumexpress.com")) {
            errors.rejectValue("CommunicationDTO.email", "email.invalid");
        }
    }
}
