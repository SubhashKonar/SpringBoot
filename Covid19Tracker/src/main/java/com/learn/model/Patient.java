package com.learn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.validator.EnumValidator;
import com.learn.validator.FamilyValidator;
import com.learn.validator.PatientStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PATIENTS")

public class Patient implements Cloneable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Size(max = 10,min = 10,message = "Invalid Length")
	@Pattern(regexp = "^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$", message = "Incorrect Pan No")
	
	@Column(unique=true)
	private String pan;
	
	@Valid
	@Size(max = 10,min = 10,message = "Invalid Length")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Incorrect Mobile No")
	@Column(unique=true)
	private  String mobile;
	
	@Valid
	@Size(max = 12,min = 12,message = "Invalid Length")
	@Pattern(regexp = "^[1-9]\\d{11}$", message = "Incorrect Aadhaar No")
	@Column(unique=true)
	private String aadhaar;
	
	@NotEmpty(message = "name is mandatory")
	private String name;
	
	@NotEmpty(message = "pincode is mandatory")
	@Size(max = 6,min = 6,message = "Invalid Length")
	@Pattern(regexp = "^[1-9]\\d{5}$", message = "Incorrect Pincode")
	private String pincode;
	
	private String city;
	private String district;
	private String state;
	
	@EnumValidator(enumClass =PatientStatus.class,message="Accepted values Active,Discharged,Deceased")
	private String status;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@FamilyValidator
	@Valid
	@JoinColumn(name="patient_id")
	@JsonManagedReference
	private  List<FamilyMember> familymembers=new ArrayList<FamilyMember>();

	 public  Object clone() throws
     CloneNotSupportedException 
		{ 
		 Patient patient = (Patient) super.clone();
		 patient.familymembers = new ArrayList<>(this.familymembers);
		   return patient;
		
		} 

	
}

