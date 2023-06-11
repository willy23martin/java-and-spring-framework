package openweb.wmc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import openweb.wmc.model.ContactLombok;

@SpringBootApplication
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner lookbokTest() {
		return args -> {
			ContactLombok contact = new ContactLombok();
			
		};
	}

}
