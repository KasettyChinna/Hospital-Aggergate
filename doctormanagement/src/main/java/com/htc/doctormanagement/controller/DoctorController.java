package com.htc.doctormanagement.controller;

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

import com.htc.doctormanagement.dao.DoctorRepository;
import com.htc.doctormanagement.entity.Doctor;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
		
		@Autowired
		private DoctorRepository doctorRepository;

		
		 @GetMapping("/doctors")
		  public List<Doctor> getAllDoctordetails() {
		   
		    return doctorRepository.findAll();
		 
		   
		  }
		 
		
		@GetMapping("/doctors/{doctorId}")
		Doctor getDoctorbyId(@PathVariable long doctorId)
		{
			Doctor doctor=null;
			doctor=doctorRepository.findById(doctorId).get();
			return doctor;
			
		}
		
		@GetMapping("/doctors/{appointmentId}")
		Doctor getByappointmentId(@PathVariable long appointmentId)
		{
			Doctor doctor=null;
			doctor=doctorRepository.findById(appointmentId).get();
			return doctor;
			
		}
		
		@PostMapping("/doctors")
		Doctor createDoctordetails(@RequestBody Doctor doctor)
		{
			return doctorRepository.save(doctor);
			
		}
		
		@PutMapping("/doctors/{appointmentId}")
		public Doctor updateDoctor(@RequestBody Doctor newDoctor, @PathVariable long appointmentId) {
			return doctorRepository.findById(appointmentId)
					.map(doctor ->{
						doctor.setDoctorName(newDoctor.getDoctorName());
						doctor.setDoctorId(newDoctor.getDoctorId());
						return doctorRepository.save(doctor);
					})
					.orElseGet(() -> {
						newDoctor.setAppointmentId(appointmentId);
				     return doctorRepository.save(newDoctor);
				      });
		}
		
		@DeleteMapping("/doctors/{appointmentId}")
		  void deleteEmployee(@PathVariable long appointmentId) {
			doctorRepository.deleteById(appointmentId);
		  }


	}


