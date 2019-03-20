package com.defesa.domain.dto;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.defesa.domain.Funcionario;
public class FuncionarioNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	@Email(message="Email invalido")
	private String email;
	
	
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private String senha;
	
	private Integer perfil;
	
	

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public FuncionarioNewDTO() {
		
	}
	
	public FuncionarioNewDTO(Funcionario obj) {
		
	
		nome=obj.getNome();
		email=obj.getEmail();		
		senha=obj.getSenha();
		
		
		
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
	
}
