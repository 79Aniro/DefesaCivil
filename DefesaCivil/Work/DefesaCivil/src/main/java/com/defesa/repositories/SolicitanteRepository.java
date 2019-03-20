package com.defesa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defesa.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante,Integer>{

	
	
}
