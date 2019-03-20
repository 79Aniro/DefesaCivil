package com.defesa.domain.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.defesa.domain.Solicitante;
public class SolicitanteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	
	private String nome;
	
	private String email;
	
	private Integer tipoSolicitante;
	
	private Integer numeroResidencia;
	
	
	
	private Set<String> telefones = new HashSet<>();
	
	private Integer endereco;
	

	public SolicitanteDTO() {
		
	}
	
	public SolicitanteDTO(Solicitante obj) {
		
		id=obj.getId();
		nome=obj.getNome();
		email=obj.getEmail();
		tipoSolicitante=obj.getTipo_solicitante().getTipo_solicitante_id();
		numeroResidencia=obj.getNumeroResidencia();
		telefones=obj.getTelefones();
		endereco=obj.getEndereco().getEndereco_id();
		
		
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

	public Integer getTipo() {
		return tipoSolicitante;
	}

	public void setTipo(Integer tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public Integer getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(Integer numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}
	
	

	
	
}
