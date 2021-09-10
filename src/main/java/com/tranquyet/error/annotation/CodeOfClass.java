package com.tranquyet.error.annotation;

import com.tranquyet.error.validator.CodeOfClassValidator;
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
@Constraint(validatedBy = CodeOfClassValidator.class)
@Documented
public @interface CodeOfClass {

    String message() default "Invalid Code of Class!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
