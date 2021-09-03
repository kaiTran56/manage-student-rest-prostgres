package com.tranquyet.error.validator;


import com.tranquyet.error.annotation.Dob;
import com.tranquyet.util.constant.student.StudentValueConstant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DobValidator implements ConstraintValidator<Dob, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Date date = null;
        if(value==null)
            return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(StudentValueConstant.FORMAT_DATE);
            date = sdf.parse(value);
            return value.equals(sdf.format(date));
        } catch (ParseException ex) {
            return false;
        }
    }
}
