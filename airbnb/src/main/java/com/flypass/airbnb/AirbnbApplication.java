package com.flypass.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class AirbnbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbApplication.class, args);
	}
}
