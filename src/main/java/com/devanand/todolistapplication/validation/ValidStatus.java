package com.devanand.todolistapplication.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StatusValidator.class)
public @interface ValidStatus {
    String message() default "Invalid status";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}