package com.BC32.RegistrationMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class RegistrationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationMsApplication.class, args);
	}

}
