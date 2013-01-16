package com.iteye.baowp.springrest.constraints.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.iteye.baowp.springrest.constraints.HasEnglist;

public class HasEnglishValidator implements
        ConstraintValidator<com.iteye.baowp.springrest.constraints.HasEnglist, String> {

    private static String  ENGLISH = "[a-z]+";
    private static Pattern pattern = Pattern.compile(ENGLISH, Pattern.CASE_INSENSITIVE);

    public void initialize(HasEnglist constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        Matcher m = pattern.matcher(value);
        return m.find();
    }

}
