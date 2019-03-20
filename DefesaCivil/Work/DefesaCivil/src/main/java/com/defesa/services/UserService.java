package com.defesa.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.defesa.security.UserSS;

//Classe com metodo que retorna o funcionario logado

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
