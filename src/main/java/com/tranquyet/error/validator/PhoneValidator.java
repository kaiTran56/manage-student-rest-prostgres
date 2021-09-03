package com.tranquyet.error.validator;

import com.tranquyet.error.annotation.Phone;
import com.tranquyet.util.constant.student.StudentValueConstant;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value!=null&&Pattern.matches(StudentValueConstant.REGEX_PHONE, value);
    }
}
