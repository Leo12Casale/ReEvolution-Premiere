package com.reevolutionpremiere.ReEvolutionPremiere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
public class ReEvolutionPremiereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReEvolutionPremiereApplication.class, args);
	}

}
