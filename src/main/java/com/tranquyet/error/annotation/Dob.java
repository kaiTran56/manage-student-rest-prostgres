package com.tranquyet.error.annotation;

import com.tranquyet.error.validator.DobValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DobValidator.class)
@Documented
public @interface Dob {

    String message() default "Invalid Dob! (Suggestion: Must have 10 characters! or Following form: dd/MM/yyyy)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
