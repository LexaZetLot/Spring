package org.example.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.api.CommunicationDTO;

public class PhoneValidator implements ConstraintValidator<Phone, CommunicationDTO> {
   private int value;

    @Override
    public void initialize(Phone constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(CommunicationDTO phone, ConstraintValidatorContext constraintValidatorContext) {
        if (phone.getPhone() == null || phone.getPhone().getCountryCode().length() + phone.getPhone().getUserNumber().length() != value ||
                !phone.getPhone().getCountryCode().matches("-?\\d+") || !phone.getPhone().getUserNumber().matches("-?\\d+")) {
            return false;
        }
        return true;
    }
}
