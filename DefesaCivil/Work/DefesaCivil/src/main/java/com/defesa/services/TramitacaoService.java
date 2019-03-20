package com.defesa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Tramitacao;
import com.defesa.repositories.TramitacaoRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class TramitacaoService {

	@Autowired
	private TramitacaoRepository repo;

	

	public Tramitacao find(Integer id) {
		Optional<Tramitacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tramitacao.class.getName()));
	}

	@Transactional
	public Tramitacao insert(Tramitacao obj) {
		obj.setTramitacao_id(null);

		return repo.save(obj);
	}

	public Tramitacao update(Tramitacao obj) {
		Tramitacao newObj = find(obj.getTramitacao_id());
		updateData(newObj, obj);
		return repo.save(newObj);
	}



	private void updateData(Tramitacao newObj, Tramitacao obj) {

		newObj.setDescricao(obj.getDescricao());

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir");

		}

	}

	
	
	
	public Page<Tramitacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	
	public List<Tramitacao> findAll() {
		
		
		
		return repo.findAll();
	}
	
	

	public Tramitacao findByCod(Integer cod) {
		
		return repo.findByCod(cod);
	}
			
	
}