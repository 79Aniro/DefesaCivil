package com.defesa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.defesa.domain.Endereco;
import com.defesa.domain.Solicitante;
import com.defesa.domain.TipoSolicitante;
import com.defesa.domain.dto.SolicitanteDTO;
import com.defesa.repositories.SolicitanteRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class SolicitanteService {

	@Autowired
	private SolicitanteRepository repo;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private TipoSolicitanteService tipoSolService;
	
	public Solicitante find(Integer id) {
		Optional<Solicitante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Solicitante.class.getName()));
		}
	
	
	public Solicitante insert(Solicitante obj) {
		obj.setId(null);

		return repo.save(obj);
	}
	
	
	
	
public Solicitante fromDTO(SolicitanteDTO objDto) {
		
	Endereco endereco= enderecoService.find(objDto.getEndereco());//recuperando endereco por id;
	TipoSolicitante sol= tipoSolService.find(objDto.getTipo());
	
	
		return new Solicitante(objDto.getId(), objDto.getNome(), objDto.getEmail(), sol, objDto.getNumeroResidencia(), endereco);
}
	
	public Solicitante update(Solicitante obj) {
		Solicitante newObj=find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
private void updateData(Solicitante newObj, Solicitante obj) {
		
		if(obj.getNome().equals(newObj.getNome())==false && newObj.getNome().equals(null)==false   ) {
			
			newObj.setNome(obj.getNome());
			
		}
				
	}

public void delete(Integer id) {
	find(id);
	try {
		repo.deleteById(id);
	} catch (DataIntegrityViolationException e) {

		throw new DataIntegrityException("Não é possivel excluir uma ocorrencia que tenha relatorios");

	}
	
	


}

public List<Solicitante> findAll() {
	return repo.findAll();
}

public Page<Solicitante> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
	
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
			orderBy);
	
	return repo.findAll(pageRequest);
}
	
}
