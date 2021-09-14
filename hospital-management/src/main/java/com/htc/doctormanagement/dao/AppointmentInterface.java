package com.htc.doctormanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.doctormanagement.entity.Appointment;

public interface AppointmentInterface extends JpaRepository<Appointment, Long> {

}
