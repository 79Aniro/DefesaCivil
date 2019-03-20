package com.defesa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.defesa.domain.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer>{

	
	
	

	@Query("select u from Funcionario u where u.nome like %?1%")
	public List<Funcionario> findByNomeFuncionario(String nome);

	@Query("select u from Funcionario u where u.email like %?1%")
	public List<Funcionario> findByEmailFuncionario(String email);
	

	public Funcionario findByEmail(String email);
	
	
	@Query("select u from Funcionario u where u.funcionario_id=id")
	public Funcionario findByOne(Integer id);
	
	public List<Funcionario> findByPerfis(Integer perfil);
	
}
