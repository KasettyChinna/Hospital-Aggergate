package com.htc.doctormanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.doctormanagement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
