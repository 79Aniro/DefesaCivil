package com.defesa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defesa.domain.Tramitacao;




@Repository
public interface TramitacaoRepository extends JpaRepository<Tramitacao,Integer>{

	
	public Tramitacao findByCod(Integer cod);

				
	
	
}
