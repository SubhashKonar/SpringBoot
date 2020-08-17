package com.learn.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public enum PatientStatus {

	ACTIVE("Active"),
	DISCHARGED("Discharged"),
	DECEASED("Deceased");
		
	private String description;
}

