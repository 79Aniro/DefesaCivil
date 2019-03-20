package com.defesa.domain.dto;

import java.io.Serializable;

public class TipoOcorrenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String cod;

	private String descricao;

	public TipoOcorrenciaDTO() {

	}

	public TipoOcorrenciaDTO(Integer id, String cod, String descricao) {

		this.id = id;
		this.cod = cod;
		this.descricao = descricao;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
