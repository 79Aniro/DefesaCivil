package com.defesa.domain.dto;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.defesa.domain.Funcionario;
import com.defesa.domain.enums.Perfil;
public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	
	private String nome;
	private Integer perfil;
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	@Email(message="Email invalido")
	private String email;
	
	
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	private String senha;
	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public FuncionarioDTO() {
		
	}
	
	public FuncionarioDTO(Funcionario obj) {
		
		id=obj.getId();
		nome=obj.getNome();
		email=obj.getEmail();		
		senha=obj.getSenha();
		if(obj.getPerfis().contains(Perfil.ADMIN)) {
			perfil=1;
		}
		else
			if(obj.getPerfis().contains(Perfil.AGENTE)) {
				perfil=3;
				
			}
			else {
				perfil=2;
			}
		
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	

	
	
	
	
}