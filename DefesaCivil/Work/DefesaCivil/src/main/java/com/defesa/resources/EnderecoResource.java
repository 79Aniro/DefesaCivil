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

import com.defesa.domain.Endereco;
import com.defesa.domain.dto.EnderecoDTO;
import com.defesa.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
//Retorna endereco por id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {

		Endereco rua = service.find(id);

		return ResponseEntity.ok().body(rua);

	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Endereco obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getEndereco_id()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Endereco obj, @PathVariable Integer id) {

		obj.setEndereco_id(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//retorna todos enderecos
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnderecoDTO>> findAll(
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		List<EnderecoDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<List<EnderecoDTO>> findToas(
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		List<EnderecoDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Endereco>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Endereco> list = service.findPage(page, linesPerPage, orderBy, direction);
		

		return ResponseEntity.ok().body(list);

	}

	// Endpoint para busca de enderecos por nome de rua
	@RequestMapping(value = "/ruanome/{rua}", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findEnderecosNomeRua(@PathVariable String rua) {

		List<Endereco> list = service.findEnderecoNome(rua);
		return ResponseEntity.ok().body(list);

	}
	
	// Endpoint para busca de enderecos por nome do bairro completo
		@RequestMapping(value = "/ruabairro/{bairro}", method = RequestMethod.GET)
		public ResponseEntity<List<Endereco>> findEnderecosNomeBairro(@PathVariable String bairro) {

			List<Endereco> list = service.findEnderecoBairro(bairro);
			return ResponseEntity.ok().body(list);

		}
		
		// Endpoint para busca de enderecos por cep
				@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET)
				public ResponseEntity<List<Endereco>> findEnderecosCep(@PathVariable String cep) {

					List<Endereco> list = service.findEnderecoCep(cep);
					return ResponseEntity.ok().body(list);

				}

}
