package com.defesa.services;

/**
 * @author Aniro Montenegro
 * Classe de servico para definicao da regra de negocio sobre Ocorrencias
 * Deve possuir os seguintes metodos:
 * 1-Metodo de Busca por id
 * 2-Metodo de Insercao de nova Ocorrência
 * 3-Metodo de exclusão de Ocorrência
 * 4-Metodo que retorna todas as Ocorrências
 * 5-Metodo que retorna Ocorrências por regiao.
 * 6-Metodo que retorna Ocorrências por bairro.
 * 7-Metodo que retorna Ocorrências por rua.
 * 8-Metodo que retorna Ocorrências cep.
 * 9-Metodo que retorna Ocorrência por funcionario.
 * 10-Metodo que retorna Ocorrências por data de abertura.
 * 11-Metodo que retorna Ocorrências por data de atendimento.
 * 12-Metodo que retorna Ocorrências por data de fechamento.
 * 13-Metodo que retorna Ocorrências abertas.
 * 14-Metodo que retorna Ocorrências fechadas.
 * 15-Metodos que retornem Ocorrências entre datas. 
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Endereco;
import com.defesa.domain.Funcionario;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.OrigemOcorrencia;
import com.defesa.domain.Solicitante;
import com.defesa.domain.TipoOcorrencia;
import com.defesa.domain.TipoSolicitante;
import com.defesa.domain.dto.OcorrenciaDTO;
import com.defesa.domain.dto.OcorrenciaNewDTO;
import com.defesa.repositories.OcorrenciaRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository repo;

	@Autowired
	private SolicitanteService solService;
	
	@Autowired
	private TipoSolicitanteService tipoSolService;

	@Autowired
	private FuncionarioService funcService;

	@Autowired
	private EnderecoService endService;
	
	@Autowired
	private OrigemOcorrenciaService oriOcoService;
	
	
	@Autowired
	private TipoOcorrenciaService tipoOcoService;
	
	@Value("${status_ocorrencia}")
	private String status;

	/**
	 * @author Aniro Montenegro
	 * @param id Integer- Numero do id da ocorrencia no banco de dados
	 * @return Ocorrencia
	 */
	public Ocorrencia find(Integer id) {
		Optional<Ocorrencia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ocorrencia.class.getName()));
	}

	@Transactional
	public Ocorrencia insert(Ocorrencia obj) {

		obj.setId(null);
		obj.setStatus(status);
		obj.setDataAbertura(new Date(System.currentTimeMillis()));// Inserindo data de abertura

		solService.insert(obj.getSolicitante());		

		return repo.save(obj);
	}

	@Transactional
	public void delete(Integer id) {

		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir uma ocorrencia que tenha relatorios");

		}

	}

	public List<Ocorrencia> findAll() {
		return repo.findAll();
	}

	/**
	 * Retorna uma lista de ocorrencias conforme região informada
	 * 
	 * @param regiao
	 * @return List Ocorrencias
	 */

	public List<Ocorrencia> findOcorrenciasRegiao(String regiao) {

		return repo.findByEnderecoRegiao(regiao);
	}

	/**
	 * Retorna uma lista de ocorrencias conforme bairro informado
	 * 
	 * @param bairro
	 * @return List Ocorrencias
	 */
	public List<Ocorrencia> findOcorrenciasBairro(String bairro) {

		return repo.findByEnderecoBairro(bairro);
	}

	/**
	 * Retorna uma lista de ocorrencias conforme rua informada
	 * 
	 * @param rua
	 * @return List Ocorrencias
	 */
	public List<Ocorrencia> findOcorrenciasRua(String rua) {

		return repo.findByEnderecoRua(rua);
	}

	/**
	 * Retorna uma lista de ocorrencias conforme cep informado
	 * 
	 * @param cep
	 * @return List Ocorrencias
	 */
	public List<Ocorrencia> findOcorrenciasCep(String cep) {

		return repo.findByEnderecoCep(cep);
	}

	/**
	 * Retorna uma lista de ocorrencias conforme id funcionario informado
	 * @param Integer id
	 * @return List Ocorrencias
	 */
	public List<Ocorrencia> findOcorrenciasFuncionarioId(Integer id) {

		return repo.findByFuncionarioId(id);
	}
	
	/**
	 * Retorna uma lista de ocorrencias conforme data de abertura
	 * @param String dataAbertura
	 * @return List Ocorrencias
	 * @throws ParseException
	 */
	public List<Ocorrencia> findOcorrenciasDataAbertura(String dataAbertura) throws ParseException {

		Date dat= converteParaDate(dataAbertura);
		return repo.findByDataAbertura(dat);
	}
	
	
	/**
	 * Retorna uma lista de ocorrencias conforme data de atendimento
	 * @param String dataAtendimento
	 * @return List Ocorrencias
	 * @throws ParseException
	 */	
	public List<Ocorrencia> findOcorrenciasDataAtendimento(String dataAtendimento) throws ParseException {

		Date dat= converteParaDate(dataAtendimento);
		return repo.findByDataAtendimento(dat);
	}
	
	/**
	 * Retorna uma lista de ocorrencias conforme data de fechamento
	 * @param String dataFechamento
	 * @return List Ocorrencias
	 * @throws ParseException
	 */	
	public List<Ocorrencia> findOcorrenciasDataFechamento(String dataFechamento) throws ParseException {

		Date dat= converteParaDate(dataFechamento);
		return repo.findByDataConclusao(dat);
	}
	
	
	
	/**
	 * Retorna uma lista de ocorrencias conforme intervalo de datas
	 * @param String dataStart, String dataEnd
	 * @return List Ocorrencias
	 * @throws ParseException
	 */	
	public List<Ocorrencia> findOcorrenciasBetweenDataAbertura(String dataStart, String dataEnd) throws ParseException {

		Date startDate= converteParaDate(dataStart);
		Date endDate= converteParaDate(dataEnd);
		return repo.findByBetweenDataAbertura(startDate, endDate);
	}
	
	
	
	
	
	
	
	
	@Transactional
	public Ocorrencia inseredataAtendimento(Ocorrencia obj) {

		obj.setDataAtendimento(new Date(System.currentTimeMillis()));// Inserindo data de atendimento

		return repo.save(obj);
	}

	@Transactional
	public Ocorrencia inserefechandoAtendimento(Ocorrencia obj) {

		obj.setDataConclusao(new Date(System.currentTimeMillis()));// Inserindo data de fechamento
		obj.setStatus("Fechada");

		return repo.save(obj);
	}

	public Ocorrencia fromDTO(OcorrenciaDTO objDto) throws java.text.ParseException {

		return new Ocorrencia(objDto.getId(), converteParaDate(objDto.getDataAbertura()), null, null,
				objDto.getStatus(), objDto.getHistoricoInicial(), null, null, objDto.getNumeroLocal(), null, null,
				null,null);

	}

	public Ocorrencia fromDTO(OcorrenciaNewDTO objDto) {

		Endereco endereco = endService.find(objDto.getEndSolicitante());// rua do solicitante
		Endereco endereco2 = endService.find(objDto.getEndereco());// rua da ocorrencia
		Funcionario func = funcService.find(objDto.getFuncionario());//funcionario que criou ocorrencia
		Funcionario agente = funcService.find(objDto.getFuncionario());//funcionario que foi designado para a ocorrencia
		
		
		
		OrigemOcorrencia oriOcorrencia=oriOcoService.find(objDto.getOrigemOcorrencia());
		TipoSolicitante tipoSol= tipoSolService.find(objDto.getTipoSolicitante());
		TipoOcorrencia tipoOco= tipoOcoService.find(objDto.getTipoOcorrencia());
		Solicitante sol = new Solicitante(null, objDto.getNomeSolicitante(), objDto.getEmailSolicitante(),
				tipoSol, objDto.getNumeroResidenciaSolicitante(), endereco);

		if (objDto.getTelefoneSolicitante() != null) {

			sol.getTelefones().add(objDto.getTelefoneSolicitante());
		}

		if (objDto.getTelefoneSolicitante2() != null) {

			sol.getTelefones().add(objDto.getTelefoneSolicitante2());
		}

		return new Ocorrencia(null, null, null, null, null, objDto.getHistoricoInicial(),
				oriOcorrencia,tipoOco, objDto.getNumeroLocal(), func, sol, endereco2,agente);

	}

	public Ocorrencia update(Ocorrencia obj) {
		Ocorrencia newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Ocorrencia newObj, Ocorrencia obj) {

		if (obj.getFuncionario().equals(newObj.getFuncionario()) == false
				&& newObj.getFuncionario().equals(null) == false) {

			newObj.setFuncionario(obj.getFuncionario());

		}

	}

	public List<Ocorrencia> findByStatus() {
		return repo.findByStatusAberta();
	}
	
	public List<Ocorrencia> findByAgente(Integer agente){
		
		Funcionario func =funcService.find(agente);
	return 	repo.findByAgenteAndStatus(func,"Aberta");
	}

	public List<Ocorrencia> findByStatusFechada() {
		return repo.findByStatus("Fechada");
	}

	public List<Ocorrencia> findByAtendidas() {

		List<Ocorrencia> list = repo.findAll();
		List<Ocorrencia> listn = new ArrayList<Ocorrencia>();
		for (Ocorrencia o : list) {

			if (o.getDataAtendimento() != null && o.getStatus() != "Fechada") {
				listn.add(o);
			}
		}
		return listn;
	}

	
	
	
	public Page<Ocorrencia> findPageAtendidasPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		

		return repo.findByAtendidas(pageRequest);
	}
	
	
	
	public Page<Ocorrencia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findByStatus("Aberta",pageRequest);
	}
	
	
	public Page<Ocorrencia> findPageRegiao(Integer page, Integer linesPerPage, String orderBy, String direction,String regiao) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findByEnderecoRegiao(regiao, pageRequest);
	}
	

	public Page<Ocorrencia> findPageFechadas(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findByStatus("Fechada", pageRequest);
	}
	
	
	public Page<Ocorrencia> findOcorrenciasBetweenDataAberturaPage(Integer page, Integer linesPerPage, String orderBy, String direction,String dataStart, String dataEnd) throws ParseException {

		Date startDate= converteParaDate(dataStart);
		Date endDate= converteParaDate(dataEnd);
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByBetweenDataAbertura(startDate, endDate,pageRequest);
	}
	
	
	
	public static Date converteParaDate(String Data) throws java.text.ParseException {
		DateFormat formatodata = new SimpleDateFormat("dd-MM-yyyy");

		Date DataGuiaformatada3 = formatodata.parse(Data);
		return DataGuiaformatada3;

	}
	public static Date converteParaDate2(String Data) throws java.text.ParseException {
		DateFormat formatodata = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		Date DataGuiaformatada3 = formatodata.parse(Data);
		return DataGuiaformatada3;

	}

}