package com.defesa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.TipoOcorrencia;
import com.defesa.repositories.TipoOcorrenciaRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class TipoOcorrenciaService {

	@Autowired
	private TipoOcorrenciaRepository repo;

	

	public TipoOcorrencia find(Integer id) {
		Optional<TipoOcorrencia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoOcorrencia.class.getName()));
	}

	@Transactional
	public TipoOcorrencia insert(TipoOcorrencia obj) {
		obj.setTipo_ocorrencia_id(null);

		return repo.save(obj);
	}

	



	

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir uma rua que contenha relatorios");

		}

	}

	public List<TipoOcorrencia> findAll() {
		
		
		
		return repo.findAll();
	}

	
}
	
