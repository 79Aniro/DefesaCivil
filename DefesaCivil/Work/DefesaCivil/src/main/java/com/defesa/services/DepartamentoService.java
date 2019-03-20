package com.defesa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.defesa.domain.Departamento;
import com.defesa.domain.dto.DepartamentoDTO;
import com.defesa.repositories.DepartamentoRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repo;



	public Departamento find(Integer id) {

		// Departamento so recupera ele mesmo. Se for Admin recupera todos
		
		Optional<Departamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Departamento.class.getName()));
	}

	public Departamento insert(Departamento obj) {
		obj.setDepartamento_id(null);

		return repo.save(obj);
	}
	
	
	
	

	public Departamento update(Departamento obj) {
		Departamento newObj = find(obj.getDepartamento_id());
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}

	
	

	private void updateData(Departamento newObj, Departamento obj) {

		newObj.setNome(obj.getNome());

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir um funcionario que contem ocorrencias");

		}

	}

	public List<Departamento> findAll() {
		return repo.findAll();
	}

	
	public List<DepartamentoDTO> findAllDto() {
		
		List<Departamento> dep= repo.findAll();
		List<DepartamentoDTO> depDto= new ArrayList<>();
		
		for(Departamento d: dep) {
			
			depDto.add(new DepartamentoDTO(d));
		}
		return depDto;
	}
	
	/*public Departamento findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole("ADMIN") && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Departamento obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Departamento.class.getName());
		}
		return obj;
	}*/

	/*public List<Departamento> findByNome(String nome) {
		return repo.findByNomeDepartamento(nome);
	}*/

	public Page<Departamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
}
