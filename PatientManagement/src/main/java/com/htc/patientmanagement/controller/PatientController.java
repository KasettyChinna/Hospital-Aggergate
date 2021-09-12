package com.htc.patientmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.patientmanagement.dao.PatientRepository;
import com.htc.patientmanagement.model.Patient;


@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}

	
	@GetMapping("/patients/{patientId}") 
    public Patient getPatientByid(@PathVariable Long patientId) {
		
		Patient patient =null;
		patient = patientRepository.findById(patientId).get();
		return patient;
		
	}
	
	@GetMapping("/patients/{firstName}") 
    public Patient getPatientfirstName(@RequestParam String firstName) {
		
		return patientRepository.findByFirst_name(firstName);
	}

	@GetMapping("/patients/{lastName}") 
    public Patient getPatientlastName(@RequestParam String lastName) {
		
		return patientRepository.findByLast_name(lastName);
	}
	
	@GetMapping("/patients/{mobile}") 
    public Patient getPatientmobile(@RequestParam long mobile) {
		
		return patientRepository.findByMobile(mobile);
	}

	
	@PostMapping("/patients/create") 
	public Patient createProduct(@RequestBody Patient patient) {
		
		 return patientRepository.save(patient);
	}
	
	@PutMapping("/patients/{patientId}")
	public Patient updatePatient(@RequestBody Patient newpatient, @PathVariable long patientId) {
		return patientRepository.findById(patientId)
				.map(patient ->{
					patient.setDisease(newpatient.getDisease());
					
					return patientRepository.save(patient);
				})
				.orElseGet(() -> {
					newpatient.setPatientId(patientId);
			     return patientRepository.save(newpatient);
			      });
	}
	
	@DeleteMapping("/patients/{patientId}")
	  void deleteEmployee(@PathVariable long patientId) {
		patientRepository.deleteById(patientId);
	  }
}


