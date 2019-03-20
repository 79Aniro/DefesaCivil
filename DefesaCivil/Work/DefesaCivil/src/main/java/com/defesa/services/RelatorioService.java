package com.defesa.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.defesa.domain.Endereco;
import com.defesa.domain.Funcionario;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.Relatorio;
import com.defesa.domain.Tramitacao;
import com.defesa.domain.dto.RelatorioDTO;
import com.defesa.domain.dto.RelatorioNewDTO;
import com.defesa.repositories.RelatorioRepository;
import com.defesa.security.UserSS;
import com.defesa.services.exceptions.AuthorizationException;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository repo;
	@Autowired
	private FuncionarioService funcService;
	@Autowired
	private OcorrenciaService ocoService;
	@Autowired
	private EnderecoService endService;

	@Autowired
	private S3Service s3Service;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private TramitacaoService tramitacaoService;

	@Value("${img.prefix.relatorio.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;

	@Value("${tramitacao_inicial}")
	private String tramitacaoInicial;

	@Value("${tramitacao_arquivo}")
	private String tramitacaoArquivo;

	public Relatorio find(Integer id) {

		

		// Funcionario recupera somente os seus relatorios-ADMIN recupera todos

		Optional<Relatorio> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Relatorio.class.getName()));
	}

	/**
	 * Busca Relatorio sem autenticação
	 * 
	 * @param id
	 * @return Relatorio
	 */
	public Relatorio findRel(Integer id) {

		Optional<Relatorio> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Relatorio.class.getName()));

	}

	public RelatorioDTO findOne(Integer id) {

		Optional<Relatorio> rel = repo.findById(id);
		RelatorioDTO relDto = new RelatorioDTO(rel);
		return relDto;

	}

	public Relatorio findPdf(Integer id) {

		Optional<Relatorio> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Relatorio.class.getName()));

	}

	@Transactional
	public Relatorio insert(Relatorio obj) {
		obj.setId(null);

		Ocorrencia oco = ocoService.find(obj.getOcorrencia().getId());
		oco = ocoService.inseredataAtendimento(oco);
		obj.setEndereco(oco.getEndereco());
		obj.setNumeroLocal(oco.getNumeroLocal());
		ocoService.update(oco);
		obj = repo.save(obj);
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}

	@Transactional
	public Relatorio update(RelatorioDTO obj) {
		Relatorio newObj = find(obj.getId());
		newObj.setVistoria(obj.getVistoria());
		newObj.setObservacao(obj.getObservacao());
		return repo.save(newObj);
	}

	public Relatorio fromDTO(RelatorioDTO objDto) {
		Funcionario func = funcService.find(objDto.getFuncionario());
		Ocorrencia oco = ocoService.find(objDto.getOcorrencia());
		Endereco endereco = endService.findEnderecoNomeRua(objDto.getRua());
		Tramitacao tram = tramitacaoService.find(objDto.getTramitacao());

		return new Relatorio(objDto.getNumeroLocal(), objDto.getVistoria(), objDto.getObservacao(), func, endereco, oco,
				tram);

	}

	@Transactional
	public Relatorio fromDTO(RelatorioNewDTO objDto) {
		Funcionario func = funcService.find(objDto.getFuncionario());
		Ocorrencia oco = ocoService.find(objDto.getOcorrencia());
		Tramitacao tram = tramitacaoService.find(1);

		return new Relatorio(oco.getNumeroLocal(), objDto.getVistoria(), objDto.getObservacao(), func,
				oco.getEndereco(), oco, tram);

	}

	@Transactional
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir um relatorio de uma ocorrencia");

		}

	}

	public List<Relatorio> findAll() {

		return repo.findAll();
	}

	public List<RelatorioDTO> findAllFuncionario(Integer id) {// Busca Relatorios por funcionario
		Funcionario func = funcService.find(id);
		List<Relatorio> rel = repo.findByFuncionario(func);
		List<RelatorioDTO> listDto = new ArrayList<RelatorioDTO>();
		for (Relatorio r : rel) {
			if (!(r.getTramitacao().getDescricao().equals("ARQUIVO"))) {
				listDto.add(new RelatorioDTO(r));
			}
		}
		return listDto;
	}

	public List<RelatorioDTO> findRelatoriosOcorrencia(Integer idOcorrencia) {

		List<Relatorio> list = repo.findByOcorrenciaId(idOcorrencia);
		List<RelatorioDTO> listDTO = new ArrayList<RelatorioDTO>();
		for (Relatorio o : list) {

			listDTO.add(new RelatorioDTO(o));
		}
		return listDTO;
	}

	public List<RelatorioDTO> findAllDto() {

		List<Relatorio> list = repo.findAll();
		List<RelatorioDTO> listDTO = new ArrayList<RelatorioDTO>();
		for (Relatorio o : list) {

			listDTO.add(new RelatorioDTO(o));
		}
		return listDTO;
	}

	public Page<Relatorio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		UserSS user = UserService.authenticated();// Obtem o usuario logado
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Funcionario func = funcService.find(user.getId()); // Atribuindo funcionario logado a variavel func

		return repo.findByFuncionario(func, pageRequest);
	}

	public URI uploadProfilePicture(MultipartFile multipartFile, Integer id_relatorio) {
		Relatorio rel = find(id_relatorio);
		int a = rel.getUrlFoto().size();// recuperando quantidade de url
		a++;
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		String fileName = prefix + rel.getId() + "-" + a + ".jpg"; // atribuindo numero a foto do relatorio
		URI uri = s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		String b = "https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/";
		rel.addFoto(b + fileName);
		repo.save(rel);

		return uri;
	}

	public List<Relatorio> findIdOcorrencia(Integer id) {

		return repo.findByOcorrenciaId(id);
	}

	protected String converteData(java.util.Date dtData) {

		if (dtData != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = dateFormat.format(dtData);
			return strDate;
		}
		return "";

	}

	public List<String> getUrlFoto(Integer id) {

		int z = 0;

		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		Relatorio rel = findRel(id);
		String x;
		list.addAll(rel.getUrlFoto());
		for (String s : list) {
			x = imageService.foto(s);
			if (x != null) {
				list2.add(x);
			}

		}

		while (z < list2.size()) {
			list3.add(list2.get(z++));
		}

		list3.add(imageService.foto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/logo.jpg"));
		return list3;
	}

	/**
	 * Função realiza atualização do status de tramitação do relatorio
	 * 
	 * @param id
	 * @param cod
	 * @return
	 */
	@Transactional
	public Relatorio toChangeTramitacao(Integer id, Integer cod) {
		Relatorio newObj = find(id);
		Tramitacao tram = tramitacaoService.findByCod(cod);
		newObj.setTramitacao(tram);
		return repo.save(newObj);
	}

}