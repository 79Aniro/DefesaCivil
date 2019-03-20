package com.defesa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Endereco;




@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{

	
	
	@Transactional(readOnly=true)
	public List<Endereco> findAllByOrderByNome();
	
	public Endereco findByNome(String nome);
	public List<Endereco>findByRegiao(String regiao);
	public List<Endereco>findByBairro(String bairro);
	public List<Endereco>findByCep(String cep);
	
	
	@Query("select u from Endereco u where u.nome like %?1%")
	public List<Endereco> findByNomeRua(String nome);
		
		
		
		
	
	
}
