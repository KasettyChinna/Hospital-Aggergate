package com.htc.doctormanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.htc.doctormanagement.dao.AppointmentInterface;
import com.htc.doctormanagement.entity.Appointment;

@SpringBootTest
class DoctorManagementApplicationTests {
	
	@Autowired
	AppointmentInterface appointmentrepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1L);
		appointment.setAppointmentDate_Time(LocalDateTime.now());
		appointmentrepo.save(appointment);
		
		assertNotNull(appointmentrepo.findById(1L).get());
	}

}

