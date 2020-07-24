package com.tomek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.info("----------------------> Starting Spring"); 
		SpringApplication.run(Application.class, args);
		logger.info("----------------------> Ending Spring's run()"); 
	}

}
