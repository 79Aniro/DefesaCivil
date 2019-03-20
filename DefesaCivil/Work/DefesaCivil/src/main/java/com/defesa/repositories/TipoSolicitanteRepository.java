package com.defesa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defesa.domain.TipoSolicitante;

@Repository
public interface TipoSolicitanteRepository extends JpaRepository<TipoSolicitante,Integer>{

	
	
}
