package com.learn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NSDLResponseModel {
	
	private String pan;
	private Boolean panVerification;

}
