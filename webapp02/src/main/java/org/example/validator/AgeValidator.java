package org.example.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private int min;
    private int max;

    @Override
    public void initialize(Age constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer != null)
            return integer >= min && integer <= max;
        return false;
    }
}
