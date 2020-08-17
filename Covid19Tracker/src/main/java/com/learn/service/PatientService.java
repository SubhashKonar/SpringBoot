package com.learn.service;

import java.util.List;
import java.util.Optional;

import com.learn.model.Patient;

public interface PatientService  {

	public List<Patient> getPatients();
	public Patient getPatientByID(long id);
	public Patient getPatientByPan(String pan);
	public Patient getPatientByMobile(String mob);
	public Patient getPatientByAadhaar(String aadhaar);
	
	public Patient addUpdatePatient(Patient patient);
	
	
	public void deletePatientByID(long id);
	public void deletePatientByPan(String pan);
	public void deletePatientByMobile(String mob);
	public void deletePatientByAadhaar(String aadhaar);
	
	
}
