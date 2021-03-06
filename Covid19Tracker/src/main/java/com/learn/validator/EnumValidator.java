package com.learn.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

/**
 * 
 * @author konar
 *
 */

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
public @interface EnumValidator {

	Class<? extends Enum<?>> enumClass();

	String message() default "Invalid Field Value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
