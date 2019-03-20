package com.defesa.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.defesa.domain.Ocorrencia;
import com.defesa.domain.dto.OcorrenciaDTO;
import com.defesa.domain.dto.OcorrenciaNewDTO;
import com.defesa.services.OcorrenciaService;

@Controller
@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaResource {

	@Autowired
	private OcorrenciaService service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {

		Ocorrencia oco = service.find(id);

		return ResponseEntity.ok().body(oco);

	}



	@PreAuthorize("hasAnyRole('ADMIN','AGENTE','CADASTRADOR)")

	@RequestMapping(value = "/nova", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody OcorrenciaNewDTO objDto) {
		
		Ocorrencia obj = service.fromDTO(objDto);

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody OcorrenciaNewDTO objDto, @PathVariable Integer id) {
		Ocorrencia obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ocorrencia>> findAll() {

		List<Ocorrencia> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Ocorrencia> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/abertas/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> listarAbertasPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Ocorrencia> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/fechadas/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> listarFechadasPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Ocorrencia> list = service.findPageFechadas(page, linesPerPage, orderBy, direction);
		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/atendidas/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> listarAtendidasPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Ocorrencia> list = service.findPageAtendidasPage(page, linesPerPage, orderBy, direction);
		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/abertas", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarAbertas() {

		List<Ocorrencia> list = service.findByStatus();

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/fechadas", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarFechadas() {

		List<Ocorrencia> list = service.findByStatusFechada();

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/atendidas", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarAtendidas() {

		List<Ocorrencia> list = service.findByAtendidas();

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/fechar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> fecharOcorrencia(@PathVariable Integer id) {

		Ocorrencia oco = service.find(id);
		service.inserefechandoAtendimento(oco);

		return ResponseEntity.noContent().build();

	}

	/**
	 * Endpoint para busca de Ocorrências por regiao
	 * 
	 * @param String nome da regiao
	 * @return List OcorrenciaDTO
	 */
	@RequestMapping(value = "/regiao/{regiao}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasRegiao(@PathVariable String regiao) {

		List<Ocorrencia> list = service.findOcorrenciasRegiao(regiao);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca paginada de Ocorrências por regiao
	 * 
	 * @param regiao
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@RequestMapping(value = "/regiao/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> listarOcorrenciasRegiaoPage(
			@RequestParam(value = "regiao", defaultValue = "0") String regiao,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Ocorrencia> list = service.findPageRegiao(page, linesPerPage, orderBy, direction, regiao);
		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por bairro
	 * 
	 * @param String nome do bairro
	 * @return List OcorrenciaDTO
	 */
	@RequestMapping(value = "/bairro/{bairro}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasbairro(@PathVariable String bairro) {

		List<Ocorrencia> list = service.findOcorrenciasBairro(bairro);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por rua
	 * 
	 * @param String nome da rua
	 * @return List OcorrenciaDTO
	 */
	@RequestMapping(value = "/rua/{rua}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasRua(@PathVariable String rua) {

		List<Ocorrencia> list = service.findOcorrenciasRua(rua);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por cep
	 * 
	 * @param String cep
	 * @return List OcorrenciaDTO
	 */
	@RequestMapping(value = "/cep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasCep(@PathVariable String cep) {

		List<Ocorrencia> list = service.findOcorrenciasCep(cep);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por id do funcionario
	 * 
	 * @param Integer id
	 * @return List OcorrenciaDTO
	 */
	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasFuncionario(@PathVariable Integer id) {

		List<Ocorrencia> list = service.findOcorrenciasFuncionarioId(id);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por data abertura da ocorrência
	 * 
	 * @param String dataAbertura
	 * @return List OcorrenciaDTO
	 * @throws ParseException
	 */
	@RequestMapping(value = "/dataAbertura/{dataAbertura}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasDataAbertura(@PathVariable String dataAbertura)
			throws ParseException {

		List<Ocorrencia> list = service.findOcorrenciasDataAbertura(dataAbertura);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por data de atendimento da ocorrência
	 * 
	 * @param String dataAbertura
	 * @return List OcorrenciaDTO
	 * @throws ParseException
	 */
	@RequestMapping(value = "/dataAtendimento/{dataAtendimento}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasDataAtendimento(@PathVariable String dataAtendimento)
			throws ParseException {

		List<Ocorrencia> list = service.findOcorrenciasDataAtendimento(dataAtendimento);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por data abertura da ocorrência
	 * 
	 * @param String dataAbertura
	 * @return List OcorrenciaDTO
	 * @throws ParseException
	 */
	@RequestMapping(value = "/dataFechamento/{dataFechamento}", method = RequestMethod.GET)
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrenciasDataFechamento(@PathVariable String dataFechamento)
			throws ParseException {

		List<Ocorrencia> list = service.findOcorrenciasDataFechamento(dataFechamento);

		List<OcorrenciaDTO> listDto = list.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * Endpoint para busca de Ocorrências por intervalo de datas
	 * 
	 * @param String dataAbertura
	 * @return List OcorrenciaDTO
	 * @throws ParseException
	 */
	@RequestMapping(value = "/dataAberturaBetween/{dataStart}/{dataEnd}", method = RequestMethod.GET)
	public ResponseEntity<Page<OcorrenciaDTO>> listarOcorrenciasIntervaloDataFechamento(@PathVariable String dataStart,
			@PathVariable String dataEnd, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) throws ParseException {

		Page<Ocorrencia> list = service.findOcorrenciasBetweenDataAberturaPage(page, linesPerPage, orderBy, direction,
				dataStart, dataEnd);

		Page<OcorrenciaDTO> listDto = list.map(obj -> new OcorrenciaDTO(obj));

		return ResponseEntity.ok().body(listDto);

	}
}