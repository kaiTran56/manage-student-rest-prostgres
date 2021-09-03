package com.tranquyet.error.validator;


import com.tranquyet.error.annotation.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value!=(null)&&value.length()<=25&&!value.isEmpty() ;
    }
}