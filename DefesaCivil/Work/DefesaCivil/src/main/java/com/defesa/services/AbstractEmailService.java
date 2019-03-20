package com.defesa.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.defesa.domain.Funcionario;
import com.defesa.domain.Relatorio;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;



	

	@Override
	public void sendOrderConfirmationEmail(Relatorio obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromRelatorio(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromRelatorio(Relatorio obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getFuncionario().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Relatorio  confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	



	
	@Override
	public void sendNewPasswordEmail(Funcionario funcionario, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(funcionario, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Funcionario funcionario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(funcionario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}


	
	

}