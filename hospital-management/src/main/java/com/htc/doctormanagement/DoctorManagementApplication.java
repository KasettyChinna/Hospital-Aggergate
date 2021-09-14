package com.htc.doctormanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DoctorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementApplication.class, args);
	}

}
