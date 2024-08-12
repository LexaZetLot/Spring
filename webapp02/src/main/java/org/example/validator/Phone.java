package org.example.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
    int value() default 10;
    String message() default "{invalidPhoneMessage}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
