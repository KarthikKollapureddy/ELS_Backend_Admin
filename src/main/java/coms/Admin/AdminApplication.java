package coms.Admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import coms.Admin.controller.AdminController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
		
		@Bean
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}
	}


