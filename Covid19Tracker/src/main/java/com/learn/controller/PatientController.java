package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.learn.model.Patient;
import com.learn.repo.PatientRepo;
import com.learn.service.PatientService;
import com.learn.service.PatientServiceImpl;

@RestController
@Validated
@RequestMapping("/covid19")
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@GetMapping("/patientdetails")
	public List<Patient> getPatients()
	{
		return pservice.getPatients();
	}
	
	@GetMapping("/patientdetail/{id}")
	public Patient getPatient(@PathVariable  Long id)
	{
		return pservice.getPatientByID(id);
	}
	
	@GetMapping("/patientdetail/byPan/{pan}")
	public Patient getPatientByPan(@PathVariable  String pan)
	{
		return pservice.getPatientByPan(pan);
	}
	
	@GetMapping("/patientdetail/byMob/{mob}")
	public Patient getPatientByMobile(@PathVariable  String mob)
	{
		return pservice.getPatientByMobile(mob);
	}
	
	@GetMapping("/patientdetail/byAadhaar/{aadhaar}")
	public Patient getPatientByAadhaar(@PathVariable  String aadhaar)
	{
		return pservice.getPatientByAadhaar(aadhaar);
	}
	
	@PostMapping("/addpatient")
	public Patient addPatient(@Valid @RequestBody Patient patient)
	{
		
		return pservice.addUpdatePatient(patient);
	}
	
	@PostMapping("/updatePatient")
	public Patient updatePatient(@Valid @RequestBody Patient patient)
	{
		
	
		
		return pservice.addUpdatePatient(patient);
	}
	
	@DeleteMapping("/deleteByPan/{pan}")
	public String deleteByPan(@PathVariable String pan)
	{
		pservice.deletePatientByPan(pan);
		return "Patient Deleted";
	}
	
	@DeleteMapping("/deleteByMob/{mob}")
	public String deleteByMob(@PathVariable String mob)
	{
		pservice.deletePatientByMobile(mob);
		return "Patient Deleted";
	}
	
	@DeleteMapping("/deleteByAadhaar/{aadhaar}")
	public String deleteByAadhaar(@PathVariable String aadhaar)
	{
		pservice.deletePatientByAadhaar(aadhaar);
		return "Patient Deleted";
	}
}
