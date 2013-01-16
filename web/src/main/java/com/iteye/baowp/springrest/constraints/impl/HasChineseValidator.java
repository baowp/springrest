package com.iteye.baowp.springrest.constraints.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.iteye.baowp.springrest.constraints.HasChinese;

public class HasChineseValidator implements
		ConstraintValidator<HasChinese, String> {

	private static String CHINESE = "[\u4e00-\u9fa5]+";
	private static Pattern pattern = Pattern.compile(CHINESE);

	public void initialize(HasChinese annotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null)
			return true;
		Matcher m = pattern.matcher(value);
		return m.find();
	}

}
