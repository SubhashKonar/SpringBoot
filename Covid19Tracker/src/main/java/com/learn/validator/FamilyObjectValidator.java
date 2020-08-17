package com.learn.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.learn.model.FamilyMember;


public  class FamilyObjectValidator implements ConstraintValidator<FamilyValidator, List<FamilyMember>>  {

	@Override
	public boolean isValid(List<FamilyMember> value, ConstraintValidatorContext context) {
	
		return value.size()>=0;
	}

}
