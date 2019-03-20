package com.defesa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defesa.domain.Departamento;
import com.defesa.domain.dto.DepartamentoDTO;
import com.defesa.services.DepartamentoService;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoResource {

	@Autowired
	private DepartamentoService service;
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {

		Departamento func= service.find(id);
		
		return ResponseEntity.ok().body(func);

	}
	

	
	
	
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
	
	service.delete(id);
	return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Departamento>> findAll() {

		List<Departamento> list= service.findAll();
		
		return ResponseEntity.ok().body(list);

	}
	@RequestMapping(value="/dto",method = RequestMethod.GET)
	public ResponseEntity<List<DepartamentoDTO>> findAllDto() {

		List<DepartamentoDTO> list= service.findAllDto();
		
		return ResponseEntity.ok().body(list);

	}
	@RequestMapping(value="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<DepartamentoDTO>> findPage(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="nome")String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC")String direction) {

		Page<Departamento> list =service.findPage(page, linesPerPage, orderBy, direction);
		Page<DepartamentoDTO> listDto= list.map(obj-> new DepartamentoDTO(obj));
		
		return ResponseEntity.ok().body(listDto);

	}
	
	
	/*@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Departamento> find(@RequestParam(value="value") String email) {
		Departamento obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}*/
	
	
	
}
