package com.defesa.services;

import org.springframework.mail.SimpleMailMessage;

import com.defesa.domain.Funcionario;
import com.defesa.domain.Relatorio;



public interface EmailService {

	void sendOrderConfirmationEmail(Relatorio obj);
	
	void sendEmail(SimpleMailMessage msg);

	


	void sendNewPasswordEmail(Funcionario funcionario, String newPass);
	
	
}