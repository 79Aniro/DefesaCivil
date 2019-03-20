package com.defesa.domain.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class RelatorioNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String vistoria;
	private String observacao;	
	
	
	private Integer funcionario;

	private Integer tramitacao;
	
	
	private Integer ocorrencia;
	
	private Set<String> urlFoto = new HashSet<>();
	
	
	public RelatorioNewDTO() {
		
		
	}

	public String getVistoria() {
		return vistoria;
	}

	public void setVistoria(String vistoria) {
		this.vistoria = vistoria;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	


	public Integer getTramitacao() {
		return tramitacao;
	}

	public void setTramitacao(Integer tramitacao) {
		this.tramitacao = tramitacao;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	

	public Integer getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Integer ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public Set<String> getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(Set<String> urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
	
}