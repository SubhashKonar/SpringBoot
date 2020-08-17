package com.learn.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FamilyObjectValidator.class)
public @interface FamilyValidator {

	 String message() default "Invalid Family Details";

	    Class<?>[] groups() default { };

	    Class<? extends Payload>[] payload() default { };
}
