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

import com.iteye.baowp.springrest.constraints.impl.HasEnCnValidator;

@Documented
@Constraint(validatedBy = { HasEnCnValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@HasEnglist
public @interface HasEnCn {
	String message() default "必须包含中英文字符";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
