package com.defesa.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.defesa.domain.Funcionario;
import com.defesa.repositories.FuncionarioRepository;
import com.defesa.security.UserSS;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired

	private FuncionarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder bc;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Funcionario func = repo.findByEmail(email);

		if (func == null) {

			throw new ObjectNotFoundException("Email nao encontrado");
		}

		String newPass = newPassword();
		func.setSenha(bc.encode(newPass));
		repo.save(func);
		emailService.sendNewPasswordEmail(func, newPass);
	}

	/**
	 * Cadastra nova senha
	 * 
	 * @param id
	 * @param senha
	 */
	public void novaSenha(String email, String novaSenha) {
		UserSS user = UserService.authenticated();
		Funcionario func = repo.findByEmail(email);

		if (user.getUsername().equals(func.getEmail())) {

			func.setSenha(bc.encode(novaSenha));
			repo.save(func);
			emailService.sendNewPasswordEmail(func, novaSenha);
			System.out.println("Mudou");

		}

		else {
			throw new ObjectNotFoundException("Email nao encontrado");
		}

	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		} else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
