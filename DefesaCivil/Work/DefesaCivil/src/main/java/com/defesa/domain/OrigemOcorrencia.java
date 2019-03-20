package com.defesa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrigemOcorrencia implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer origem_ocorrencia_id;
	
	private String descricao;
	

	
	@JsonIgnore
	@OneToMany(mappedBy="origemOcorrencia")
	private List<Ocorrencia> ocorrencias= new ArrayList<>();
	
	

	
	
	
	public OrigemOcorrencia() {
		
	}






	public OrigemOcorrencia(Integer origem_ocorrencia_id, String descricao) {
		super();
		this.origem_ocorrencia_id = origem_ocorrencia_id;
		this.descricao = descricao;
	}






	public Integer getOrigem_ocorrencia_id() {
		return origem_ocorrencia_id;
	}






	public void setOrigem_ocorrencia_id(Integer origem_ocorrencia_id) {
		this.origem_ocorrencia_id = origem_ocorrencia_id;
	}






	public String getDescricao() {
		return descricao;
	}






	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}






	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}






	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((origem_ocorrencia_id == null) ? 0 : origem_ocorrencia_id.hashCode());
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
		OrigemOcorrencia other = (OrigemOcorrencia) obj;
		if (origem_ocorrencia_id == null) {
			if (other.origem_ocorrencia_id != null)
				return false;
		} else if (!origem_ocorrencia_id.equals(other.origem_ocorrencia_id))
			return false;
		return true;
	}



	

	


	
	
	

}
