package com.defesa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numeroLocal;
	
	
	
	@Column(length = 1200)
	private String vistoria;
	
	@Column(length = 1200)
	private String observacao;


	
	

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "tramitacao_id")
	private Tramitacao tramitacao;
	
	@ManyToOne
	@JoinColumn(name = "ocorrencia_id")
	private Ocorrencia ocorrencia;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "UrlFoto")
	@Column(length = 200000)
	private Set<String> urlFoto = new HashSet<>();

	public Relatorio() {

	}



	public Relatorio(Integer numeroLocal, String vistoria, String observacao, Funcionario funcionario,
			Endereco endereco, Ocorrencia ocorrencia, Tramitacao tramitacao) {
		super();
		this.numeroLocal = numeroLocal;
		this.vistoria = vistoria;
		this.observacao = observacao;
		this.funcionario = funcionario;
		this.endereco = endereco;
		this.ocorrencia = ocorrencia;
		this.tramitacao = tramitacao;
		
	}
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	

	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public Integer getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(Integer numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	public void addFoto(String foto) {

		urlFoto.add(foto);
	}

	public Set<String> getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(Set<String> urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	


	public Tramitacao getTramitacao() {
		return tramitacao;
	}



	public void setTramitacao(Tramitacao tramitacao) {
		this.tramitacao = tramitacao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Relatorio other = (Relatorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String fromAterro(boolean b) {

		if (b == true)
			return "Sim";
		else
			return "Não";
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\nRelatorio id= ");
		builder.append(getId());
		builder.append("\nOcorrencia= ");
		builder.append(getOcorrencia().getId());
		builder.append("\nHistorico = ");
		builder.append(getOcorrencia().getHistoricoInicial());
		builder.append("\nRua= ");
		builder.append(getEndereco().getNome());
		builder.append("\nNumero= ");
		builder.append(getNumeroLocal());
		builder.append("\nVistoria= ");
		builder.append(getVistoria());	
		builder.append(getFuncionario().getNome());
		builder.append("\nObservacao= ");
		builder.append(getObservacao());
		builder.append("]");
		return builder.toString();
	}

}