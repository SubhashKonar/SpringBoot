package com.learn.model;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
	private String name;
	private String panVerification;
	private String degreeScore;
	private List<CIBILScore> cibilScores;

}
