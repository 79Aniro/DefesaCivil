package com.defesa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Endereco;
import com.defesa.domain.Funcionario;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.Relatorio;


@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {

	

	public List<Relatorio> findByObservacao(String observacao);



	public List<Relatorio> findByFuncionario(Funcionario funcionario);

	@Query("select u from Relatorio u where u.funcionario.funcionario_id = id")
	public List<Relatorio> findByFuncionarioId(Integer id);

	public List<Relatorio> findByEndereco(Endereco endereco);

	public List<Relatorio> findByOcorrencia(Ocorrencia ocorrencia);

	public List<Relatorio> findByOcorrenciaId(Integer id);
	
	
	@Transactional(readOnly=true)
	Page<Relatorio> findByFuncionario(Funcionario func, Pageable pageRequest);

}
