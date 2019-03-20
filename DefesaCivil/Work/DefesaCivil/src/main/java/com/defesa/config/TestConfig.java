package com.defesa.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.defesa.services.DBService;
import com.defesa.services.EmailService;
import com.defesa.services.MockEmailService;



@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		dbService.insert();
		
		return true;
	}
	
	@Bean
	public EmailService emailSErvice() {
		
		return new MockEmailService();
	}
	
}
