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
public class TipoSolicitante implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tipo_solicitante_id;
	
	private String descricao;
	

	
	@JsonIgnore
	@OneToMany(mappedBy="tipo_solicitante")
	private List<Solicitante> solicitantes= new ArrayList<>();
	
	

	
	
	
	public TipoSolicitante() {
		
	}



	public TipoSolicitante(Integer tipo_solicitante_id, String descricao) {
		super();
		this.tipo_solicitante_id = tipo_solicitante_id;
		this.descricao = descricao;
	}



	public Integer getTipo_solicitante_id() {
		return tipo_solicitante_id;
	}



	public void setTipo_solicitante_id(Integer tipo_solicitante_id) {
		this.tipo_solicitante_id = tipo_solicitante_id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		result = prime * result + ((tipo_solicitante_id == null) ? 0 : tipo_solicitante_id.hashCode());
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
		TipoSolicitante other = (TipoSolicitante) obj;
		if (tipo_solicitante_id == null) {
			if (other.tipo_solicitante_id != null)
				return false;
		} else if (!tipo_solicitante_id.equals(other.tipo_solicitante_id))
			return false;
		return true;
	}

	


	
	
	

}
