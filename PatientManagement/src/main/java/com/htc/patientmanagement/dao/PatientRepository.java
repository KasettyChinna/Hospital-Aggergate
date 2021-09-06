package com.htc.patientmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.patientmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
