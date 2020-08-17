package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.learn.model.Patient;
import com.learn.repo.PatientRepo;
import com.learn.service.PatientService;
import com.learn.service.PatientServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Validated
@RequestMapping("/covid19")
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@ApiOperation(value = "Finds all the patients details.",
			response =Patient.class )
	@GetMapping("/patientdetails")
	public List<Patient> getPatients()
	{
		return pservice.getPatients();
	}
	
	@ApiOperation(value = "Finds patient details by id.")
	@GetMapping("/patientdetail/{id}")
	public Patient getPatient(@ApiParam(value="ID of the patient to be fetch",required = true) @PathVariable  Long id)
	{
		return pservice.getPatientByID(id);
	}
	
	@ApiOperation(value = "Finds patient details by Pan.")
	@GetMapping("/patientdetail/byPan/{pan}")
	public Patient getPatientByPan(@ApiParam(value="PAN of the patient to be fetch",required = true) @PathVariable  String pan)
	{
		return pservice.getPatientByPan(pan);
	}
	
	@ApiOperation(value = "Finds patient details by Mobile.")
	@GetMapping("/patientdetail/byMob/{mob}")
	public Patient getPatientByMobile(@ApiParam(value="Mobile of the patient to be fetch",required = true) @PathVariable  String mob)
	{
		return pservice.getPatientByMobile(mob);
	}
	
	@ApiOperation(value = "Finds patient details by Aadhaar.")
	@GetMapping("/patientdetail/byAadhaar/{aadhaar}")
	public Patient getPatientByAadhaar(@PathVariable  String aadhaar)
	{
		return pservice.getPatientByAadhaar(aadhaar);
	}
	
	@ApiOperation(value = "Adds Patient details.")
	@PostMapping("/addpatient")
	public Patient addPatient(@Valid @RequestBody Patient patient)
	{
		
		return pservice.addUpdatePatient(patient);
	}
	
	@ApiOperation(value = "Updates Patient details.")
	@PutMapping("/updatePatient")
	public Patient updatePatient(@Valid @RequestBody Patient patient)
	{
		
	
		
		return pservice.addUpdatePatient(patient);
	}
	
	@ApiOperation(value = "Deteles Patient details by Pan")
	@DeleteMapping("/deleteByPan/{pan}")
	public String deleteByPan(@PathVariable String pan)
	{
		pservice.deletePatientByPan(pan);
		return "Patient Deleted";
	}
	
	@ApiOperation(value = "Deteles Patient details by Mobile")
	@DeleteMapping("/deleteByMob/{mob}")
	public String deleteByMob(@PathVariable String mob)
	{
		pservice.deletePatientByMobile(mob);
		return "Patient Deleted";
	}
	
	@ApiOperation(value = "Deteles Patient details by Aadhaar")
	@DeleteMapping("/deleteByAadhaar/{aadhaar}")
	public String deleteByAadhaar(@PathVariable String aadhaar)
	{
		pservice.deletePatientByAadhaar(aadhaar);
		return "Patient Deleted";
	}
}
