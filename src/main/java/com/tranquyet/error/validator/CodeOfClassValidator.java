package com.tranquyet.error.validator;

import com.tranquyet.error.annotation.CodeOfClass;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CodeOfClassValidator implements ConstraintValidator<CodeOfClass, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.isEmpty();
    }
}
