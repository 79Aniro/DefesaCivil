package com.defesa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defesa.domain.Solicitante;
import com.defesa.domain.dto.SolicitanteDTO;
import com.defesa.services.SolicitanteService;

@RestController
@RequestMapping(value = "/solicitantes")
public class SolicitanteResource {

	@Autowired
	private SolicitanteService service;
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {

		Solicitante sol= service.find(id);
		
		return ResponseEntity.ok().body(sol);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SolicitanteDTO objDto){
		Solicitante obj=service.fromDTO(objDto);
		obj=service.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SolicitanteDTO objDto,@PathVariable Integer id){
		Solicitante obj=service.fromDTO(objDto);
		obj.setId(id);
		obj=service.update(obj);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
	
	service.delete(id);
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Solicitante>> findAll() {

		List<Solicitante> list= service.findAll();
		
		return ResponseEntity.ok().body(list);

	}

	
	@RequestMapping(value="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<SolicitanteDTO>> findPage(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="nome")String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC")String direction) {

		Page<Solicitante> list =service.findPage(page, linesPerPage, orderBy, direction);
		Page<SolicitanteDTO> listDto= list.map(obj-> new SolicitanteDTO(obj));
		
		return ResponseEntity.ok().body(listDto);

	}
}
