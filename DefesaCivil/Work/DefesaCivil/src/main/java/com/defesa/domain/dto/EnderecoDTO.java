package com.defesa.domain.dto;


import java.io.Serializable;

import com.defesa.domain.Endereco;
public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;	
	private String nome;	
	private String cep;
	private String regiao;
	private String bairro;
	

	

	

	public EnderecoDTO() {
		
	}
	
	public EnderecoDTO(Endereco obj) {
		
		id=obj.getEndereco_id();
		nome=obj.getNome();
		cep=obj.getCep();
		 regiao=obj.getRegiao();
		 bairro=obj.getBairro();
		
		
		
		
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
	
	

	
	
	
	
}
