package com.BC32.ConfigurationMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationMsApplication.class, args);
	}

}
