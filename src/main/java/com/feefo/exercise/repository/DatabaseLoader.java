package com.feefo.exercise.repository;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.feefo.exercise.model.*;

 @Component
 public class DatabaseLoader implements CommandLineRunner {

 	private final JobRepository jobRepository;


 	@Autowired

 	public DatabaseLoader(JobRepository jobRepository) {
 		this.jobRepository = jobRepository;
	}

 	@Override
 	public void run(String... strings) throws Exception {

		this.jobRepository.save(new Job("Architect"));
		this.jobRepository.save(new Job("Software engineer"));
		this.jobRepository.save(new Job("Quantity surveyor"));
		this.jobRepository.save(new Job("Accountant"));

 		

 	}
 }
