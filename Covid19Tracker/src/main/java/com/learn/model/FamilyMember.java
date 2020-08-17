package com.learn.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FAMILYMEMEBER")
public class FamilyMember {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@NotNull(message = "cannot be empty")
	private String name;
	
	@NotNull(message = "cannot be empty")
	private String relation;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	private Patient patient;
}
