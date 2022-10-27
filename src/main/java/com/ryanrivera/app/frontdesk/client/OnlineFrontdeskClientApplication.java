package com.ryanrivera.app.frontdesk.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OnlineFrontdeskClientApplication {

	public static void main(String[] args) {
		log.info("Starting FrontDesk Client Application...");
		SpringApplication.run(OnlineFrontdeskClientApplication.class, args);
	}

}
