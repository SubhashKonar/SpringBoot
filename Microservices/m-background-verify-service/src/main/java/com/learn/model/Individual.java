package com.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Individual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Size(max = 10,min = 10,message = "Invalid Length")
	@Pattern(regexp = "^[4-9]{1}[0-9]{9}$", message = "Incorrect Mobile No")
	@Column(unique=true)
	private String phone;
	
	
	private String email;
	
	
	@Size(max = 10,min = 10,message = "Invalid Length")
	@Pattern(regexp = "^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$", message = "Incorrect Pan No")
	@Column(unique=true)
	private String pan;
	
	private String universityCode;
	
	private String degreecertificateNo;

}
