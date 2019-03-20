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
import org.springframework.transaction.annotation.Transactional;

import com.defesa.domain.Endereco;
import com.defesa.domain.dto.EnderecoDTO;
import com.defesa.repositories.EnderecoRepository;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	

	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	@Transactional
	public Endereco insert(Endereco obj) {
		obj.setEndereco_id(null);

		return repo.save(obj);
	}

	public Endereco update(Endereco obj) {
		Endereco newObj = find(obj.getEndereco_id());
		updateData(newObj, obj);
		return repo.save(newObj);
	}



	private void updateData(Endereco newObj, Endereco obj) {

		newObj.setNome(obj.getNome());

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir uma rua que contenha relatorios");

		}

	}

	public List<EnderecoDTO> findAll() {
		
		List<Endereco> list=repo.findAll();
		List<EnderecoDTO> listDto= new ArrayList<EnderecoDTO>();
		for(Endereco e: list) {
			
			listDto.add(new EnderecoDTO(e));
		}
		return listDto;
	}

	public Page<Endereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	public List<Endereco> findEnderecoCep(String cep) {
		return repo.findByCep(cep);
	}
	
	public List<Endereco> findEnderecoNome(String nome) {//busca por parte do nome da rua
		return repo.findByNomeRua(nome);
	}
	
	public Endereco findEnderecoNomeRua(String nome) {//busca por  nome da rua
		return repo.findByNome(nome);
	}
	
	public List<Endereco> findEnderecoBairro(String bairro) {
		return repo.findByBairro(bairro);
	}
	
	public List<Endereco> findEnderecoRegiao(String regiao) {
		return repo.findByRegiao(regiao);
	}
	
	
	
}
	
