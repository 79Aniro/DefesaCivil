package com.defesa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Funcionario;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.OrigemOcorrencia;
import com.defesa.domain.Solicitante;
import com.defesa.domain.TipoOcorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Integer>{

	
	@Query("select u from Ocorrencia u where u.status = 'Aberta'")
	public List<Ocorrencia> findByStatusAberta();
	
	@Query("select u from Ocorrencia u where u.funcionario.funcionario_id =id")
	public List<Ocorrencia> findByFuncionarioId(Integer id);
	
	@Query("select u from Ocorrencia u where u.endereco.regiao like %?1%")
	public List<Ocorrencia> findByEnderecoRegiao(String regiao);
	
	@Query("select u from Ocorrencia u where u.endereco.bairro like %?1%")
	public List<Ocorrencia> findByEnderecoBairro(String bairro);
	
	@Query("select u from Ocorrencia u where u.endereco.nome like %?1%")
	public List<Ocorrencia> findByEnderecoRua(String nome);
	
	@Query("select u from Ocorrencia u where u.endereco.cep like %?1%")
	public List<Ocorrencia> findByEnderecoCep(String cep);
	
	public List<Ocorrencia> findByDataAbertura(Date dataAbertura);
	
	@Query("select u from Ocorrencia u where u.dataAbertura BETWEEN ?1 AND ?2")
	public List<Ocorrencia> findByBetweenDataAbertura(Date startdataAbertura,Date enddataAbertura );
	
	@Transactional(readOnly=true)
	@Query("select u from Ocorrencia u where u.dataAbertura BETWEEN ?1 AND ?2")
	public Page<Ocorrencia> findByBetweenDataAbertura(Date startdataAbertura,Date enddataAbertura, Pageable pageRequest );
	
	@Query("select u from Ocorrencia u where u.dataAtendimento BETWEEN ?1 AND ?2")
	public List<Ocorrencia> findByBetweenDataAtendimento(Date startDate,Date endDate );
	
	@Query("select u from Ocorrencia u where u.dataConclusao BETWEEN ?1 AND ?2")
	public List<Ocorrencia> findByBetweenDataFechamento(Date startDate,Date endDate);
	
	public List<Ocorrencia> findByDataConclusao(Date dataConclusao);
	
	public List<Ocorrencia> findByDataAtendimento(Date dataAtendimento);
	
	public List<Ocorrencia> findByStatus(String status);	
	
	public List<Ocorrencia> findByHistoricoInicial(String historicoInicial);

	public List<Ocorrencia> findByOrigemOcorrencia(OrigemOcorrencia origemOcorrencia);

	public List<Ocorrencia> findByTipoOcorrencia(TipoOcorrencia tipoOcorrencia);

	public List<Ocorrencia> findByFuncionario(Funcionario funcionario);

	public List<Ocorrencia> findByAgenteAndStatus(Funcionario agente, String status);

	public List<Ocorrencia> findBySolicitante(Solicitante solicitante);
		
	@Transactional(readOnly=true)
	Page<Ocorrencia> findByStatus(String status, Pageable pageRequest);

	@Transactional(readOnly=true)
	Page<Ocorrencia> findByEnderecoRegiao(String regiao, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	@Query("select u from Ocorrencia u where u.dataAbertura!=null and u.status!='Fechada'")
	public Page<Ocorrencia> findByAtendidas( Pageable pageRequest );
}



