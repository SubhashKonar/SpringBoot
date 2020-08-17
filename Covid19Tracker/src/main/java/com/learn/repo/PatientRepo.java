package com.learn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.Patient;



@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	public Optional<Patient> findByPan(String pan);
	public Optional<Patient> findByMobile(String mobile);
	public Optional<Patient> findByAadhaar(String aadhaar);
	
	public void deleteByPan(String pan);
	public void deleteByMobile(String mobile);
	public void deleteByAadhaar(String aadhaar);
	
}
