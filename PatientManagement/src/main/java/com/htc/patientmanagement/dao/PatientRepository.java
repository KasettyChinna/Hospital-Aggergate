package com.htc.patientmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.htc.patientmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query(value = "SELECT patient_id,disease,first_name,last_name,mobile FROM patient WHERE first_name=?1",nativeQuery = true)
	public Patient findByFirst_name(String firstName);
	
	@Query(value = "SELECT patient_id,disease,first_name,last_name,mobile FROM patient WHERE last_name=?1",nativeQuery = true)
	public Patient findByLast_name(String lastName);
	
	@Query(value = "SELECT patient_id,disease,first_name,last_name,mobile FROM patient WHERE mobile=?1",nativeQuery = true)
	public Patient findByMobile(long mobile);
}
