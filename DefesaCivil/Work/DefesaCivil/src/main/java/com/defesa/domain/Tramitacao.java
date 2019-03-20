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
public class Tramitacao implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tramitacao_id;
	
	private String descricao;	

	
	private Integer cod;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "tramitacao", cascade = CascadeType.ALL)
	private List<Relatorio> relatorios = new ArrayList<>();
	

	

	public Tramitacao() {
		
		
	}




	



	public Tramitacao(Integer tramitacao_id, Integer cod, String descricao) {
		super();
		this.tramitacao_id = tramitacao_id;
		this.descricao = descricao;
		this.cod = cod;
	}








	public Integer getTramitacao_id() {
		return tramitacao_id;
	}




	public void setTramitacao_id(Integer tramitacao_id) {
		this.tramitacao_id = tramitacao_id;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public Integer getCod() {
		return cod;
	}








	public void setCod(Integer cod) {
		this.cod = cod;
	}








	public List<Relatorio> getRelatorios() {
		return relatorios;
	}




	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tramitacao_id == null) ? 0 : tramitacao_id.hashCode());
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
		Tramitacao other = (Tramitacao) obj;
		if (tramitacao_id == null) {
			if (other.tramitacao_id != null)
				return false;
		} else if (!tramitacao_id.equals(other.tramitacao_id))
			return false;
		return true;
	}
	
	

	

	

	
	
	
}