package com.defesa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.defesa.domain.Departamento;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.OrigemOcorrencia;
import com.defesa.domain.enums.Perfil;
import com.defesa.repositories.OrigemOcorrenciaRepository;
import com.defesa.security.UserSS;
import com.defesa.services.exceptions.AuthorizationException;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class OrigemOcorrenciaService {

	@Autowired
	private OrigemOcorrenciaRepository repo;

	@Autowired
	private OcorrenciaService ocoService;

	public OrigemOcorrencia find(Integer id) {

		

		Optional<OrigemOcorrencia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Departamento.class.getName()));
	}



	
	public OrigemOcorrencia insert(OrigemOcorrencia obj) {
		obj.setOrigem_ocorrencia_id(null);

		return repo.save(obj);
	}
	
	
	
	

	public OrigemOcorrencia update(OrigemOcorrencia obj) {
		OrigemOcorrencia newObj = find(obj.getOrigem_ocorrencia_id());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	
	

	private void updateData(OrigemOcorrencia newObj, OrigemOcorrencia obj) {

		newObj.setDescricao(obj.getDescricao());

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir um funcionario que contem ocorrencias");

		}

	}

	public List<OrigemOcorrencia> findAll() {
		return repo.findAll();
	}

	
	public List<Ocorrencia> findOcoOrigem(Integer cod){
		
		List<Ocorrencia> list= ocoService.findAll();
		
		List<Ocorrencia> listNew = new ArrayList<Ocorrencia>();
		for(Ocorrencia o: list) {
			if(o.getId()==cod) {
				listNew.add(o);
			}
		}
		
		return listNew;
	}
	
	
}
