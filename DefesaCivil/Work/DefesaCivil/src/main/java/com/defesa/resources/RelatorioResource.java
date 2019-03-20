package com.defesa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defesa.domain.Relatorio;
import com.defesa.domain.dto.RelatorioDTO;
import com.defesa.domain.dto.RelatorioNewDTO;
import com.defesa.services.RelatorioService;

@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioResource {

	@Autowired
	private RelatorioService service;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<RelatorioDTO> listar(@PathVariable Integer id) {

		RelatorioDTO rel = service.findOne(id);

		return ResponseEntity.ok().body(rel);

	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody RelatorioNewDTO objDto) {
		Relatorio obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody RelatorioDTO objDto) {
		service.update(objDto);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RelatorioDTO>> findAll() {

		List<RelatorioDTO> list = service.findAllDto();

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/idfuncionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<RelatorioDTO>> findAllFuncionario(@PathVariable Integer id) {

		List<RelatorioDTO> list = service.findAllFuncionario(id);

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<RelatorioDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Relatorio> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<RelatorioDTO> listDto = list.map(obj -> new RelatorioDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/page/func", method = RequestMethod.GET)
	public ResponseEntity<Page<Relatorio>> findPageFunc(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

		Page<Relatorio> list = service.findPage(page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/picture/{id_relatorio}", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name = "file") MultipartFile file,
			@PathVariable Integer id_relatorio) {
		URI uri = service.uploadProfilePicture(file, id_relatorio);
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/ocorrencia/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<RelatorioDTO>> relatorioOcorrencia(@PathVariable Integer id) {

		List<RelatorioDTO> list = service.findRelatoriosOcorrencia(id);

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/geturlFoto/{id}", method = RequestMethod.GET) // Retorna lista de url para criacao do pdf.
	public ResponseEntity<List<String>> relatorioGetFotos(@PathVariable Integer id) {

		List<String> list = service.getUrlFoto(id);
		

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/tramitacaoUpdate/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateTramitacao(@PathVariable Integer id,

			@RequestParam(value = "cod") Integer cod) {
		service.toChangeTramitacao(id, cod);
		return ResponseEntity.noContent().build();

	}
}