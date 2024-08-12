package org.example.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
    int min() default 18;
    int max() default 60;
    String message() default "{invalidAgeMessage}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}