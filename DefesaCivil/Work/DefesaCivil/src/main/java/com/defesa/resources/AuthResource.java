package com.defesa.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defesa.domain.dto.EmailDTO;
import com.defesa.security.JWTUtil;
import com.defesa.security.UserSS;
import com.defesa.services.AuthService;
import com.defesa.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthService service;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	/**
	 * Recupera o acesso ao sistema. O usuario recebe um e-mail com nova senha
	 * 
	 * @param objDto
	 * @return
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());

		return ResponseEntity.noContent().build();
	}

	/**
	 * Endpoint para criacao de nova senha
	 * 
	 * @param email
	 * @param novaSenha
	 * @return
	 */
	@RequestMapping(value = "/novasenha", method = RequestMethod.POST)
	public ResponseEntity<Void> novaSenha(@RequestParam(value = "email", defaultValue = "0") String email,

			@RequestParam(value = "novaSenha", defaultValue = "0") String novaSenha) {

		service.novaSenha(email, novaSenha);

		return ResponseEntity.noContent().build();
	}
}
