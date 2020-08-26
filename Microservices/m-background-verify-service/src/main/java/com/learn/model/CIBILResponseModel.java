package com.learn.model;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CIBILResponseModel {
	private String pan;
	private Boolean panverfication;
	private List<CIBILScore> cibilScores;
}
