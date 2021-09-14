package com.htc.doctormanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.doctormanagement.dao.DoctorInterface;
import com.htc.doctormanagement.entity.Doctor;
import com.htc.doctormanagement.service.DoctorServices;
@RestController
public class DoctorController {
	@Autowired
	private DoctorInterface hospitalInterface;
	
	@Autowired
	private DoctorServices hospitalServices;


	@PostMapping("/hospital")
	public Doctor insertInfo(@RequestBody Doctor hospital)
	{
		return hospitalServices.insert(hospital);
		
	}
	
	 @GetMapping("/hospital")
	  public List<Doctor> getAllInfo() {
	   
	    List<Doctor> hospitallist = hospitalInterface.findAll();
	    return hospitallist;
	  }
	 
	 @GetMapping("/hospital/{doctorId}")
		public Doctor getBydoctorId(@PathVariable Long doctorId)
		{
			Doctor doctor=null;
			doctor=hospitalInterface.findById(doctorId).get();
			return doctor;
			
		}
		
		@PutMapping("/hospital/{appointmentId}")
		public Doctor updateDoctor(@RequestBody Doctor changes, @PathVariable long appointmentId) {
			return hospitalInterface.findById(appointmentId)
					.map(doctor ->{
						doctor.setDoctorName(changes.getDoctorName());
						doctor.setDoctorId(changes.getDoctorId());
						return hospitalInterface.save(doctor);
					})
					.orElseGet(() -> {
						changes.setDoctorId(changes.getDoctorId());
				     return hospitalInterface.save(changes);
				      });
		}
		
		@DeleteMapping("/hospital/{appointmentId}")
		 public void deleteDoctor(@PathVariable long appointmentId) {
			hospitalInterface.deleteById(appointmentId);
		  }
		
	
}
