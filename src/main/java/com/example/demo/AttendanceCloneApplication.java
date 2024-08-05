package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan({"com.controller","com.dao","com.service","com.model"})
@EnableJpaRepositories(basePackages="com.dao")
@EntityScan("com.model")
public class AttendanceCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceCloneApplication.class, args);
		System.out.println("Working...");
	}

}
