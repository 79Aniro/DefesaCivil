package com.defesa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer endereco_id;
	
	private String nome;	
	private String cep;
	private String regiao;
	private String bairro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	private List<Relatorio> relatorios = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	private List<Solicitante> solicitantes = new ArrayList<>();
	

	public Endereco() {
		
		
	}
	
	

	public Endereco(Integer endereco_id, String nome,String bairro,  String regiao, String cep) {
		super();
		this.endereco_id = endereco_id;
		this.nome = nome;
		this.cep = cep;
		this.regiao = regiao;
		this.bairro = bairro;
	}

	

	public Integer getEndereco_id() {
		return endereco_id;
	}



	public void setEndereco_id(Integer endereco_id) {
		this.endereco_id = endereco_id;
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

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	public List<Solicitante> getSolicitantes() {
		return solicitantes;
	}

	public void setSolicitantes(List<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco_id == null) ? 0 : endereco_id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (endereco_id == null) {
			if (other.endereco_id != null)
				return false;
		} else if (!endereco_id.equals(other.endereco_id))
			return false;
		return true;
	}



	

	
	
	
}