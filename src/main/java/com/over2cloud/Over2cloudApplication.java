package com.over2cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class Over2cloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Over2cloudApplication.class, args);
	}

}
																																								