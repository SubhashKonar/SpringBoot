package com.learn.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

	List<String> valueList = null;

	@Override
	public void initialize(EnumValidator constraintAnnotation) {
		valueList = new ArrayList<>();
		Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

		@SuppressWarnings("rawtypes")
		Enum[] enumValArr = enumClass.getEnumConstants();

		for (@SuppressWarnings("rawtypes")
		Enum enumVal : enumValArr) {
			valueList.add(enumVal.toString().toUpperCase());
		}

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		if (!valueList.contains(value.toUpperCase())) {
			return false;
		}
		return true;
	}

}
