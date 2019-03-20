package com.defesa.domain.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.defesa.domain.Relatorio;

public class RelatorioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String rua;
	private String regiao;
	private String bairro;

	private Integer ocorrencia;

	private Integer numeroLocal;
	private String vistoria;

	private String observacao;
	
	private String solicitante;
	private String telefone;
	private String  origemOcorrencia;
	
	private String ano;
	
	private Integer tramitacao;
	private String tramitacao_descricao;

	private Integer funcionario;
	private String historicoInicial;
	
	private Integer tamanhoUrlFotos;



	private Set<String> urlFoto = new HashSet<>();

	public RelatorioDTO() {

	}

	
	public RelatorioDTO(Relatorio obj) {
		super();
		Set<String> telefonesList=obj.getOcorrencia().getSolicitante().getTelefones();
		
		this.id = obj.getId();
		this.funcionario = obj.getFuncionario().getId();
		this.rua = obj.getEndereco().getNome();
		this.bairro = obj.getEndereco().getBairro();
		this.regiao = obj.getEndereco().getRegiao();
		this.ocorrencia = obj.getOcorrencia().getId();
		this.numeroLocal = obj.getNumeroLocal();
		this.urlFoto = obj.getUrlFoto();
		this.observacao = obj.getObservacao();
		this.vistoria = (obj.getVistoria());
		this.solicitante=obj.getOcorrencia().getSolicitante().getNome();
		this.telefone=telefonesList.iterator().next();
		this.origemOcorrencia=obj.getOcorrencia().getOrigemOcorrencia().getDescricao();
		this.ano=String.valueOf(obj.getOcorrencia().getDataAbertura().toString().substring(0, 4));
		this.tramitacao=obj.getTramitacao().getTramitacao_id();		
		this.historicoInicial=obj.getOcorrencia().getHistoricoInicial();
		this.tramitacao_descricao=obj.getTramitacao().getDescricao();
		this.tamanhoUrlFotos=obj.getUrlFoto().size();

	}
	public RelatorioDTO(Optional<Relatorio> obj) {
		super();
		Set<String> telefonesList=obj.get().getOcorrencia().getSolicitante().getTelefones();
		
		this.id = obj.get().getId();
		this.funcionario = obj.get().getFuncionario().getId();
		this.rua = obj.get().getEndereco().getNome();
		this.bairro = obj.get().getEndereco().getBairro();
		this.regiao = obj.get().getEndereco().getRegiao();
		this.ocorrencia = obj.get().getOcorrencia().getId();
		this.numeroLocal = obj.get().getNumeroLocal();
		this.urlFoto = obj.get().getUrlFoto();
		this.observacao = obj.get().getObservacao();
		this.vistoria = (obj.get().getVistoria());
		this.solicitante=obj.get().getOcorrencia().getSolicitante().getNome();
		this.telefone=telefonesList.iterator().next();
		this.origemOcorrencia=obj.get().getOcorrencia().getOrigemOcorrencia().getDescricao();
		this.ano=String.valueOf(obj.get().getOcorrencia().getDataAbertura().toString().substring(0, 4));
		this.tramitacao=obj.get().getTramitacao().getTramitacao_id();
		this.tramitacao_descricao=obj.get().getTramitacao().getDescricao();
		this.historicoInicial=obj.get().getOcorrencia().getHistoricoInicial();
		this.tamanhoUrlFotos=obj.get().getUrlFoto().size();
	}
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(Integer numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Set<String> getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(Set<String> urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getVistoria() {
		return vistoria;
	}

	public void setVistoria(String vistoria) {
		this.vistoria = vistoria;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getOrigemOcorrencia() {
		return origemOcorrencia;
	}

	public void setOrigemOcorrencia(String origemOcorrencia) {
		this.origemOcorrencia = origemOcorrencia;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}


	public Integer getTramitacao() {
		return tramitacao;
	}


	public void setTramitacao(Integer tramitacao) {
		this.tramitacao = tramitacao;
	}


	public String getTramitacao_descricao() {
		return tramitacao_descricao;
	}


	public void setTramitacao_descricao(String tramitacao_descricao) {
		this.tramitacao_descricao = tramitacao_descricao;
	}


	public String getHistoricoInicial() {
		return historicoInicial;
	}


	public void setHistoricoInicial(String historicoInicial) {
		this.historicoInicial = historicoInicial;
	}





	public Integer getTamanhoUrlFotos() {
		return tamanhoUrlFotos;
	}


	public void setTamanhoUrlFotos(Integer tamanhoUrlFotos) {
		this.tamanhoUrlFotos = tamanhoUrlFotos;
	}
	

}