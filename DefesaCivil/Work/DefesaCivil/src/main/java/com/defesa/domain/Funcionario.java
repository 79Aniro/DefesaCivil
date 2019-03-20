package com.defesa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.defesa.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer funcionario_id;

	private String nome;

	private String email;

	@JsonIgnore
	private String senha;

	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Perfis")
	private Set<Integer> perfis = new HashSet<>();
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="funcionario")
	private List<Ocorrencia> ocorrencias= new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="funcionario")
	private List<Relatorio> relatorios= new ArrayList<>();
	
	public Funcionario() {
		
		addPerfil(Perfil.CADASTRADOR);
		
	}
	

	public Funcionario(Integer id, String nome, String email,String senha) {
		super();
		this.funcionario_id = id;
		this.nome = nome;
		this.email = email;		
		this.senha=senha;
		addPerfil(Perfil.CADASTRADOR);
	}
	
	public Funcionario(String nome, String email,String senha, Integer perfil) { //Construtor para novo funcionario
		super();
		
		this.nome = nome;
		this.email = email;		
		this.senha=senha;
		if(perfil==1) { //verifica perfil informado
			addPerfil(Perfil.ADMIN);
			addPerfil(Perfil.CADASTRADOR);
		}
		else
		if(perfil==3) {
			addPerfil(Perfil.AGENTE);
			addPerfil(Perfil.CADASTRADOR);
		}
		else if(perfil==2) {
			addPerfil(Perfil.CADASTRADOR);
		}
		 // todo usuario é um cadastrador
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}


	public Integer getId() {
		return funcionario_id;
	}

	public void setId(Integer id) {
		this.funcionario_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis(){
		
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
				perfis.add(perfil.getCod());
			}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}


	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario_id == null) ? 0 : funcionario_id.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (funcionario_id == null) {
			if (other.funcionario_id != null)
				return false;
		} else if (!funcionario_id.equals(other.funcionario_id))
			return false;
		return true;
	}

	
	
	
	
	
}