package com.defesa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ocorrencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataAbertura;
	private Date dataConclusao;
	private Date dataAtendimento;

	private String status;
	@Column(length = 300)
	private String historicoInicial;

	

	
	private Integer numeroLocal;
	
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "funcionario_id",referencedColumnName="funcionario_id")
	private Funcionario funcionario;
	
	
	
	@ManyToOne
	@JoinColumn(name = "agente_id",referencedColumnName="funcionario_id")
	private Funcionario agente;

	@ManyToOne
	@JoinColumn(name = "solicitante_id")
	private Solicitante solicitante;

	@ManyToOne
	@JoinColumn(name = "origem_ocorrencia_id")
	private OrigemOcorrencia origemOcorrencia;
	
	@ManyToOne
	@JoinColumn(name = "tipo_ocorrencia_id")
	private TipoOcorrencia tipoOcorrencia;
	

	@JsonIgnore
	@OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
	private List<Relatorio> relatorios = new ArrayList<>();

	public Ocorrencia() {

	}

	

	public Ocorrencia(Integer id, Date dataAbertura, Date dataConclusao, Date dataAtendimento, String status,
			String historicoInicial, OrigemOcorrencia origemOcorrencia, TipoOcorrencia tipoOcorrencia, Integer numeroLocal,
			Funcionario funcionario, Solicitante solicitante, Endereco endereco, Funcionario agente) {
		super();
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.dataConclusao = dataConclusao;
		this.dataAtendimento = dataAtendimento;
		this.status = status;
		this.historicoInicial = historicoInicial;
		this.origemOcorrencia = origemOcorrencia;
		this.tipoOcorrencia = tipoOcorrencia;
		this.numeroLocal = numeroLocal;
		this.funcionario = funcionario;
		this.solicitante = solicitante;
		this.endereco=endereco;
		this.agente=agente;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
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

	

	public OrigemOcorrencia getOrigemOcorrencia() {
		return origemOcorrencia;
	}



	public void setOrigemOcorrencia(OrigemOcorrencia origemOcorrencia) {
		this.origemOcorrencia = origemOcorrencia;
	}





	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}



	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public Integer getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(Integer numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	

	
	
	public Funcionario getAgente() {
		return agente;
	}



	public void setAgente(Funcionario agente) {
		this.agente = agente;
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
		Ocorrencia other = (Ocorrencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}






	@Override
	public String toString() {
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("Ocorrencia [id= ");
		builder.append(getId());
		builder.append("\n Rua= ");
		builder.append(getEndereco().getNome());
		builder.append("\n Numero= ");
		builder.append(getNumeroLocal());
		builder.append("\n Data Abertura= ");
		builder.append(getDataAbertura());
		builder.append("\n Data Conclusao= ");
		builder.append(getDataConclusao());
		builder.append("\n Data Atendimento= ");
		builder.append(getDataAtendimento());
		builder.append("\n Status= ");
		builder.append(getStatus());
		builder.append("\n Historico Inicial= ");
		builder.append(getHistoricoInicial());
		builder.append("\n Origem Ocorrencia= ");
		builder.append(getOrigemOcorrencia());
		builder.append("\n Tipo Ocorrencia= ");
		builder.append(getTipoOcorrencia());		
		builder.append("\n Funcionario= ");
		builder.append(getFuncionario().getNome());
		builder.append("\n Solicitante= ");
		builder.append(getSolicitante().getNome());
		
		builder.append("]");
		return builder.toString();
	}




	
	

}