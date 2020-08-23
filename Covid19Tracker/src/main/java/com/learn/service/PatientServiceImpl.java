package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.exception.PatientNotFoundException;
import com.learn.model.Patient;
import com.learn.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepo prepo;
	
	@Override
	public List<Patient> getPatients() {
		
		return prepo.findAll();
	}

	@Override
	public Patient getPatientByID(long id) {
		
		return prepo.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found for the given id "+id) );
	}

	@Override
	public Patient getPatientByPan(String pan) {
		return prepo.findByPan(pan).orElseThrow(()-> new PatientNotFoundException("Patient not found for the given pan "+pan) );
		
	}

	@Override
	public Patient getPatientByMobile(String mob) {
		return prepo.findByMobile(mob).orElseThrow(()-> new PatientNotFoundException("Patient not found for the given mobile no "+mob) );
		
	}
	
	

	@Override
	public Patient getPatientByAadhaar(String aadhaar) {
		return prepo.findByAadhaar(aadhaar).orElseThrow(()-> new PatientNotFoundException("Patient not found for the given Aadhaar no "+aadhaar) );
		
	}

	@Override
	public Patient addUpdatePatient(Patient patient) {
		
		
		Optional<Patient> foundPoptional=prepo.findByAadhaar(patient.getAadhaar());
		if(foundPoptional.isPresent())
		{
			Patient existingPatient=foundPoptional.get();
			existingPatient.setStatus(patient.getStatus());
			
			//existingPatient.setFamilymembers(patient.getFamilymembers());
			return  prepo.save(existingPatient);
		}
		// by mobile
		 foundPoptional=prepo.findByMobile(patient.getMobile());
		if(foundPoptional.isPresent())
		{
			Patient existingPatient=foundPoptional.get();
			existingPatient.setStatus(patient.getStatus());
			
			//existingPatient.setFamilymembers(patient.getFamilymembers());
			return  prepo.save(existingPatient);
		}
		// by pan
		 foundPoptional=prepo.findByPan(patient.getPan());
		if(foundPoptional.isPresent())
		{
			Patient existingPatient=foundPoptional.get();
			existingPatient.setStatus(patient.getStatus());
			
			//existingPatient.setFamilymembers(patient.getFamilymembers());
			return  prepo.save(existingPatient);
		}
		
		return  prepo.save(patient);
	}

	

	@Override
	public void deletePatientByID(long id) {
		 prepo.deleteById(id);
	}

	@Override
	public void deletePatientByPan(String pan) {
		prepo.deleteByPan(pan);
	}

	@Override
	public void deletePatientByMobile(String mob) {
		prepo.deleteByMobile(mob);
	}

	@Override
	public void  deletePatientByAadhaar(String aadhaar) {
		prepo.deleteByAadhaar(aadhaar);
	}



}
