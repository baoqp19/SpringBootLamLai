package com.example.ProjectSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// @SpringBootApplication(exclude = {
// 		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
// 		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
// )
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class ProjectSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringbootApplication.class, args);
	}

}
