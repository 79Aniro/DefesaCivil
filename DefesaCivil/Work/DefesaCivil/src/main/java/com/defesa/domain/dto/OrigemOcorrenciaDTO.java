package com.defesa.domain.dto;


import java.io.Serializable;
public class OrigemOcorrenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cod;
	
	
	private String descricao;
	
	
	
	
public OrigemOcorrenciaDTO() {
	
}
	
	
	public OrigemOcorrenciaDTO(Integer cod,String descricao) {
		
	
		this.cod=cod;
		this.descricao=descricao;
		
		
	}







	public Integer getCod() {
		return cod;
	}







	public void setCod(Integer cod) {
		this.cod = cod;
	}







	public String getDescricao() {
		return descricao;
	}







	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	

	
	
	
	
}
