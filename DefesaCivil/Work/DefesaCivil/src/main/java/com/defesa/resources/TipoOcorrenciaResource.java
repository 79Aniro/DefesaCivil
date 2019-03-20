package com.defesa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.defesa.domain.TipoOcorrencia;
import com.defesa.services.TipoOcorrenciaService;

@RestController
@RequestMapping(value = "/tipoOcorrencia")
public class TipoOcorrenciaResource {

	@Autowired
	private TipoOcorrenciaService service;
	
	
	
	

	
	@RequestMapping(value="/tipos",method = RequestMethod.GET)
	public ResponseEntity<List<TipoOcorrencia>> listarTipos() {

		List<TipoOcorrencia> list= service.findAll();
		
	
		
		return ResponseEntity.ok().body(list);

	}
	
	
}
