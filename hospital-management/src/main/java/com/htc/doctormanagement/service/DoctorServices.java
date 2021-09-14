package com.htc.doctormanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.htc.doctormanagement.dao.AppointmentInterface;
import com.htc.doctormanagement.dao.DoctorInterface;
import com.htc.doctormanagement.entity.Doctor;
@Service
public class DoctorServices {

	@Autowired
	private DoctorInterface hospitalInterface;

	@Autowired
	private AppointmentInterface appointmentInterface;

	@Transactional
	public Doctor insert(Doctor hospital) {
		Doctor insertedInfo = hospitalInterface.save(hospital);
		return insertedInfo;
	}
	
	

}
