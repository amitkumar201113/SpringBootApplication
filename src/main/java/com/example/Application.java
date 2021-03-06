package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	 
	public static void main(String[] args) {
		logger.error("Message logged at ERROR level");
	    logger.warn("Message logged at WARN level");
	    logger.info("Message logged at INFO level");
	    logger.debug("Message logged at DEBUG level");
		SpringApplication.run(Application.class, args);
		
		
	}
}
