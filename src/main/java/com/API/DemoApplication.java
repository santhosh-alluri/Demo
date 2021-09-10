package com.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.apache.logging.log4j.*;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {
    private static final Logger LOGGER = LogManager.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		
	
		SpringApplication.run(DemoApplication.class, args);
		LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
    	LOGGER.debug("This is debug message");
		LOGGER.info("This is info message");
		LOGGER.warn("This is warn message");
		LOGGER.fatal("This is fatal message");
		LOGGER.error("This is error message");
	}
	

}
