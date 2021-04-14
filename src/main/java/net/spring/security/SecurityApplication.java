package net.spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {

	private final DatabasePopulator databasePopulator;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

	}

	@PostConstruct
	public void populate(){
		databasePopulator.populateDatabase();
	}

}
