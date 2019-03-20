package com.defesa.domain.dto;

import java.io.Serializable;

public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer perfil;
	
	
	
	public PerfilDTO(Integer id, Integer perfil) {
		super();
		this.id = id;
		this.perfil = perfil;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getPerfil() {
		return perfil;
	}



	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	
	

}
