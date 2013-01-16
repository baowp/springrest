package com.iteye.baowp.springrest.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import com.iteye.baowp.springrest.constraints.impl.HasEnglishValidator;

@Documented
@Constraint(validatedBy = { HasEnglishValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@NotNull
public @interface HasEnglist {
	String message() default "必须包含英文字符";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
