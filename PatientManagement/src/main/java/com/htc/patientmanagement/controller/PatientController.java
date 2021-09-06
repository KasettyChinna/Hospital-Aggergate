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
import org.springframework.web.bind.annotation.RestController;

import com.htc.patientmanagement.dao.PatientRepository;
import com.htc.patientmanagement.model.Patient;


@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/products")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}

	
	@GetMapping("/patients/{patientId}") 
    public Patient getPatientByid(@PathVariable Long patientId) {
		
		Patient patient =null;
		patient = patientRepository.findById(patientId).get();
		return patient;
		
	}
	
//	@GetMapping("/patients/{firstName}") 
//    public List<Patient> getPatientfirstName(@PathVariable String firstName) {
//		
//		Patient patient =null;
//		patient = patientRepository.
//		return patient;
//		
//	}
//	
//	@GetMapping("/patients/{lastName}") 
//	public List<Patient> getPatientBylastName(@PathVariable(name="lastName") String lastName) {
//		List<Patient> patient = null;
//		try {
//			patient = ipatientservice.getByLastName(lastName);
//		} catch (PatientNotFound e) {
//			System.out.println(e.getErrorMessage());
//		}
//		return patient;
//	}
//	
//	@GetMapping("/patients/{mobile}") 
//	public List<Patient> getByMobile(@PathVariable(name="mobile") long mobile) {
//		List<Patient> patient = null;
//		try {
//			patient = ipatientservice.getByMobile(mobile);
//		} catch (PatientNotFound e) {
//			System.out.println(e.getErrorMessage());
//		}
//		return patient;
//	}
	
	@PostMapping("/patients/create") 
	public Patient createProduct(@RequestBody Patient patient) {
		
		 return patientRepository.save(patient);
	}
	
	@PutMapping("/patients/{patientId}")
	public Patient updatePatient(@RequestBody Patient newpatient, @PathVariable long patientId) {
		return patientRepository.findById(patientId)
				.map(patient ->{
					patient.setDisease(newpatient.getDisease());
					patient.setAddress(newpatient.getAddress());
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


