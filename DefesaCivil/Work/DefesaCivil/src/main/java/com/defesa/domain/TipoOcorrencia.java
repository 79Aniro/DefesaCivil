package com.defesa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class TipoOcorrencia implements Serializable {	
	

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tipo_ocorrencia_id;
	
	private String codigo;
	
	private String descricao;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();



	public TipoOcorrencia() {
		
	}



	public TipoOcorrencia(Integer tipo_ocorrencia_id, String codigo, String descricao) {
		super();
		this.tipo_ocorrencia_id = tipo_ocorrencia_id;
		this.codigo = codigo;
		this.descricao = descricao;
	}



	public Integer getTipo_ocorrencia_id() {
		return tipo_ocorrencia_id;
	}



	public void setTipo_ocorrencia_id(Integer tipo_ocorrencia_id) {
		this.tipo_ocorrencia_id = tipo_ocorrencia_id;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((tipo_ocorrencia_id == null) ? 0 : tipo_ocorrencia_id.hashCode());
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
		TipoOcorrencia other = (TipoOcorrencia) obj;
		if (tipo_ocorrencia_id == null) {
			if (other.tipo_ocorrencia_id != null)
				return false;
		} else if (!tipo_ocorrencia_id.equals(other.tipo_ocorrencia_id))
			return false;
		return true;
	}
	
	
	
	
	
}
