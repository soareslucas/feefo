package com.feefo.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;


@SpringBootApplication
@EntityScan(basePackages = {
        "com.feefo.exercise.model"
        })
@EnableJpaRepositories(basePackages = {
        "com.feefo.exercise.repository"
        })
public class ReactAndSpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactAndSpringDataRestApplication.class, args);
	}
}
