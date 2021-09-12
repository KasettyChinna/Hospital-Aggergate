package com.htc.hospitalaggregate.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.htc.hospitalaggregate.entity.Patient;

@Component
@FeignClient(url = "http://localhost:8008",name="Hospital-Service")
public interface HospitalServices {
	@GetMapping("/patients/{id}")
	Patient getPatientById(@PathVariable("id") Long id);
}
 