package com.defesa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Departamento implements Serializable {	
	

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departamento_id;
	
	private String nome;
	
	private String email;
	private Integer numeroResidencia;
	
	private String telefone;

	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	public Departamento(Integer id, String nome, String email, Integer numeroResidencia, String telefone ) {
		super();
		this.departamento_id = id;
		this.nome = nome;
		this.email = email;
		this.numeroResidencia=numeroResidencia;
		this.setTelefone(telefone);
	}
	


	
	public Departamento() {
		
	}

	

	public Integer getDepartamento_id() {
		return departamento_id;
	}




	public void setDepartamento_id(Integer departamento_id) {
		this.departamento_id = departamento_id;
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
	
	
	
	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	



	public Integer getNumeroResidencia() {
		return numeroResidencia;
	}








	public void setNumeroResidencia(Integer numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamento_id == null) ? 0 : departamento_id.hashCode());
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
		Departamento other = (Departamento) obj;
		if (departamento_id == null) {
			if (other.departamento_id != null)
				return false;
		} else if (!departamento_id.equals(other.departamento_id))
			return false;
		return true;
	}

	
	
	
	
	
}
