package com.learn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CIBILScore {


    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter
	private String pan;
	private String month;
	private String score;
	
}
