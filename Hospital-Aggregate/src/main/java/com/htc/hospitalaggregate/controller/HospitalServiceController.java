package com.htc.hospitalaggregate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.htc.hospitalaggregate.entity.Patient;
import com.htc.hospitalaggregate.externalservices.HospitalServices;

@RestController
public class HospitalServiceController {

	@Autowired
	HospitalServices hospitalServices;
	

	private static final Logger logger=LoggerFactory.getLogger(HospitalServiceController.class);
	
	@GetMapping("/hospital_service/patients/{id}")
	Patient getProduct(@PathVariable Long id){
		logger.toString();
		return hospitalServices.getPatientById(id);
		
	}
	
	/*
	 * @GetMapping("/aggregate/recommendation/{id}") List<Recommendation>
	 * getRecommendation(@PathVariable Long id) { List<Recommendation>
	 * recommendations=new ArrayList<>();
	 * recommendations.addAll(recomendationService.getRecommendationByProductId(id).
	 * getContent());
	 * log.info("No of recommendation retireved"+recommendations.size()); return
	 * recommendations; }
	 */
	
}
