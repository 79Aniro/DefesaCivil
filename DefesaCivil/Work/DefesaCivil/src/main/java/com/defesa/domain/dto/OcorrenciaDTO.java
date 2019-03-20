package com.defesa.domain.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.defesa.domain.Ocorrencia;

public class OcorrenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String dataAbertura;
	private String dataAtendimento;
	private String dataConclusao;

	private String status;
	private String historicoInicial;

	private String rua;
	private String bairro;
	private String regiao;
	private String cep;
	
	private String nomeFuncionario;
	private Integer idFuncionario;

	private Integer numeroLocal;
	
	private String tipo;
	private String origem;
	
	private Integer agente;

	public OcorrenciaDTO() {

	}

	public OcorrenciaDTO(Ocorrencia obj) {

		this.id = obj.getId();
		this.dataAbertura = converteData(obj.getDataAbertura());
		this.status = obj.getStatus();
		this.historicoInicial = obj.getHistoricoInicial();
		this.regiao=obj.getEndereco().getRegiao();
		this.bairro=obj.getEndereco().getBairro();
		this.rua = obj.getEndereco().getNome();
		this.numeroLocal = obj.getNumeroLocal();
		this.dataAtendimento=converteData(obj.getDataAtendimento());
		this.dataConclusao=converteData(obj.getDataConclusao());
		this.cep=obj.getEndereco().getCep();
		this.nomeFuncionario=obj.getFuncionario().getNome();
		this.idFuncionario=obj.getFuncionario().getId();
		this.tipo=obj.getTipoOcorrencia().getDescricao();
		this.origem=obj.getOrigemOcorrencia().getDescricao();
		this.agente=obj.getAgente().getId();
		

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHistoricoInicial() {
		return historicoInicial;
	}

	public void setHistoricoInicial(String historicoInicial) {
		this.historicoInicial = historicoInicial;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(Integer numeroLocal) {
		this.numeroLocal = numeroLocal;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(String dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	protected String converteData(java.util.Date dtData) {

		if(dtData!=null) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = dateFormat.format(dtData);
			return strDate;
		}
		return "";
		
		
	}

	public Integer getAgente() {
		return agente;
	}

	public void setAgente(Integer agente) {
		this.agente = agente;
	}

	

	
}