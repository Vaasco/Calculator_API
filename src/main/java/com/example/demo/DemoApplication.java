package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point of the Spring Boot application.
 */
@SpringBootApplication // Enables auto-configuration, component scanning, and Spring Boot configuration.
public class DemoApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		// Launches the Spring Boot application, initializing the application context.
		SpringApplication.run(DemoApplication.class, args);
	}
}
