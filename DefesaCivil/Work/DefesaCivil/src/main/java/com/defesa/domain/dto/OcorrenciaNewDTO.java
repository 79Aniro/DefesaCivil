package com.defesa.domain.dto;

//Classe para inserção de uma nova ocorrencia

import java.io.Serializable;

public class OcorrenciaNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String historicoInicial;

	private Integer origemOcorrencia;

	private Integer tipoOcorrencia;
	
	private Integer numeroLocal;

	private Integer endereco;

	private Integer funcionario;

	private String nomeSolicitante;

	private String emailSolicitante;

	private Integer tipoSolicitante;
	private Integer numeroResidenciaSolicitante;

	private Integer endSolicitante;

	private String telefoneSolicitante;
	private String telefoneSolicitante2;
	
	private Integer agente;

	public OcorrenciaNewDTO() {

	}
	

	public OcorrenciaNewDTO(String historicoInicial, Integer origemOcorrencia, Integer tipoOcorrencia,
			Integer numeroLocal, Integer endereco, Integer funcionario, String nomeSolicitante, String emailSolicitante,
			Integer tipoSolicitante, Integer numeroResidenciaSolicitante, Integer endSolicitante,
			String telefoneSolicitante, String telefoneSolicitante2, Integer agente) {
		super();
		this.historicoInicial = historicoInicial;
		this.origemOcorrencia = origemOcorrencia;
		this.tipoOcorrencia = tipoOcorrencia;
		this.numeroLocal = numeroLocal;
		this.endereco = endereco;
		this.funcionario = funcionario;
		this.nomeSolicitante = nomeSolicitante;
		this.emailSolicitante = emailSolicitante;
		this.tipoSolicitante = tipoSolicitante;
		this.numeroResidenciaSolicitante = numeroResidenciaSolicitante;
		this.endSolicitante = endSolicitante;
		this.telefoneSolicitante = telefoneSolicitante;
		this.telefoneSolicitante2 = telefoneSolicitante2;
		this.agente=agente;
	}


	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}

	public String getHistoricoInicial() {
		return historicoInicial;
	}

	public void setHistoricoInicial(String historicoInicial) {
		this.historicoInicial = historicoInicial;
	}

	public Integer getOrigemOcorrencia() {
		return origemOcorrencia;
	}

	public void setOrigemOcorrencia(Integer origemOcorrencia) {
		this.origemOcorrencia = origemOcorrencia;
	}

	public Integer getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(Integer tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Integer getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(Integer numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	public Integer getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public String getEmailSolicitante() {
		return emailSolicitante;
	}

	public void setEmailSolicitante(String emailSolicitante) {
		this.emailSolicitante = emailSolicitante;
	}

	public Integer getTipoSolicitante() {
		return tipoSolicitante;
	}

	public void setTipoSolicitante(Integer tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public Integer getNumeroResidenciaSolicitante() {
		return numeroResidenciaSolicitante;
	}

	public void setNumeroResidenciaSolicitante(Integer numeroResidenciaSolicitante) {
		this.numeroResidenciaSolicitante = numeroResidenciaSolicitante;
	}

	public Integer getEndSolicitante() {
		return endSolicitante;
	}

	public void setEndSolicitante(Integer endSolicitante) {
		this.endSolicitante = endSolicitante;
	}

	public String getTelefoneSolicitante() {
		return telefoneSolicitante;
	}

	public void setTelefoneSolicitante(String telefoneSolicitante) {
		this.telefoneSolicitante = telefoneSolicitante;
	}

	public String getTelefoneSolicitante2() {
		return telefoneSolicitante2;
	}

	public void setTelefoneSolicitante2(String telefoneSolicitante2) {
		this.telefoneSolicitante2 = telefoneSolicitante2;
	}


	public Integer getAgente() {
		return agente;
	}


	public void setAgente(Integer agente) {
		this.agente = agente;
	}

}