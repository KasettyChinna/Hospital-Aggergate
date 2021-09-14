package com.htc.hospitalaggregate.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.htc.hospitalaggregate.entity.Doctor;
import com.htc.hospitalaggregate.entity.Patient;

@Component
@FeignClient(url = "http://localhost:8009",name="doctormanagement")
public interface HospitalServices {
	@GetMapping("/hospital/{doctorId}")
	Doctor getDoctorById(@PathVariable("doctorId") Long doctorId);
}
 