package com.defesa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.defesa.domain.Ocorrencia;
import com.defesa.domain.OrigemOcorrencia;
import com.defesa.domain.dto.OcorrenciaDTO;
import com.defesa.domain.dto.OrigemOcorrenciaDTO;
import com.defesa.services.OrigemOcorrenciaService;

@RestController
@RequestMapping(value = "/origemOcorrencia")
public class OrigemOcorrenciaResource {

	@Autowired
	private OrigemOcorrenciaService service;
	
	
	
	@RequestMapping(value="/cod",method = RequestMethod.GET)
	public ResponseEntity<List<Ocorrencia>> listarOcorrenciasTipo(@PathVariable Integer cod) {

		List<Ocorrencia> list= service.findOcoOrigem(cod);
		
	
		
		return ResponseEntity.ok().body(list);

	}
	
	@RequestMapping(value="/tipos",method = RequestMethod.GET)
	public ResponseEntity<List<OrigemOcorrencia>> listarTipos() {

		List<OrigemOcorrencia> list= service.findAll();
		
	
		
		return ResponseEntity.ok().body(list);

	}

	
}
