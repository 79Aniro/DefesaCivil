package com.defesa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.defesa.domain.TipoSolicitante;
import com.defesa.repositories.TipoSolicitanteRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class TipoSolicitanteService {

	@Autowired
	private TipoSolicitanteRepository repo;
	

	
	public TipoSolicitante find(Integer id) {
		Optional<TipoSolicitante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoSolicitante.class.getName()));
		}
	
	
	public TipoSolicitante insert(TipoSolicitante obj) {
		obj.setTipo_solicitante_id(null);

		return repo.save(obj);
	}
	
	
	
	

	
	public TipoSolicitante update(TipoSolicitante obj) {
		TipoSolicitante newObj=find(obj.getTipo_solicitante_id());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
private void updateData(TipoSolicitante newObj, TipoSolicitante obj) {
		
		if(obj.getDescricao().equals(newObj.getDescricao())==false && newObj.getDescricao().equals(null)==false   ) {
			
			newObj.setDescricao(obj.getDescricao());
			
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

public List<TipoSolicitante> findAll() {
	return repo.findAll();
}

public Page<TipoSolicitante> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
	
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
			orderBy);
	
	return repo.findAll(pageRequest);
}
	
}
