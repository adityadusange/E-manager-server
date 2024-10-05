package com.company.employers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.company.employers")
@EntityScan(basePackages = "com.company")
public class EmployersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployersApplication.class, args);
	}

}
