package com.defesa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defesa.domain.TipoOcorrencia;

@Repository
public interface TipoOcorrenciaRepository extends JpaRepository<TipoOcorrencia,Integer>{
		
	
	
		
}
