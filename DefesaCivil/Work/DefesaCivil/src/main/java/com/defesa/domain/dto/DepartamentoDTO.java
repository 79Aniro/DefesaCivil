package com.defesa.domain.dto;


import java.io.Serializable;

import com.defesa.domain.Departamento;
public class DepartamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	
	private String nome;
	

	private String email;
	
	
	private String telefone;
	

	
	private String rua;
	private String bairro;
	private String regiao;
	private String cep;
	private Integer id_rua;
	private Integer numeroResidencia;
	

	

	

	public DepartamentoDTO() {
		
	}
	
	public DepartamentoDTO(Departamento obj) {
		
		id=obj.getDepartamento_id();
		nome=obj.getNome();
		email=obj.getEmail();
		telefone=obj.getTelefone();		
		rua=obj.getEndereco().getNome();
		bairro=obj.getEndereco().getBairro();
		regiao=obj.getEndereco().getRegiao();
		cep=obj.getEndereco().getCep();
		setId_rua(obj.getEndereco().getEndereco_id());
		numeroResidencia=obj.getNumeroResidencia();
		
		
		
		
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId_rua() {
		return id_rua;
	}

	public void setId_rua(Integer id_rua) {
		this.id_rua = id_rua;
	}

	public Integer getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(Integer numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	

	
	
	
	
}
