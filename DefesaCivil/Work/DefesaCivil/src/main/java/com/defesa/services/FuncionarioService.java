package com.defesa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.defesa.domain.Funcionario;
import com.defesa.domain.dto.FuncionarioDTO;
import com.defesa.domain.dto.FuncionarioNewDTO;
import com.defesa.domain.dto.FuncionarioPerfilDTO;
import com.defesa.domain.enums.Perfil;
import com.defesa.repositories.FuncionarioRepository;
import com.defesa.security.UserSS;
import com.defesa.services.exceptions.AuthorizationException;
import com.defesa.services.exceptions.DataIntegrityException;
import com.defesa.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	

	@Autowired
	private BCryptPasswordEncoder pe;

	public Funcionario find(Integer id) {

		/*// Funcionario so recupera ele mesmo. Se for Admin recupera todos
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado daqui");
		}*/

		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	
	
	public Funcionario findOne(Integer id) {
		
		List<Funcionario> list= findAll();
		Funcionario func= new Funcionario();
		for(Funcionario f:list) {
			
			if(f.getId()==id) {
				func=f;
				break;
			}
		}
		
		return func;
		
	}

	public Funcionario insert(Funcionario obj) {
		obj.setId(null);

		return repo.save(obj);
	}
	
	public Funcionario insertNewwFuncionario(FuncionarioNewDTO obj) {
		
		Funcionario func = fromNewDTO(obj);
		func.setId(null);
	

		return repo.save(func);
	}
	
	
	public FuncionarioPerfilDTO buscaPerfil(Integer id) {
		Funcionario fun=repo.findById(id).orElseThrow(null);
		FuncionarioPerfilDTO func = new FuncionarioPerfilDTO(fun);
		return func;
	}



	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	private void updateData(Funcionario newObj, Funcionario obj) {

		newObj.setNome(obj.getNome());

	}
	
	
	
	
	
	public Funcionario fromDTO(FuncionarioDTO objDto) {

		return new Funcionario(objDto.getId(), objDto.getNome(), objDto.getEmail(), pe.encode(objDto.getSenha()));

	}
	
	
	/**
	 * 
	 * @param objDto
	 * @return Novo Funcionario
	 *  
	 */
	public Funcionario fromNewDTO(FuncionarioNewDTO objDto) {

		return new Funcionario(objDto.getNome(), objDto.getEmail(), pe.encode(objDto.getSenha()),objDto.getPerfil());

	}
	

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possivel excluir um funcionario que contem ocorrencias");

		}

	}

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	public Funcionario findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Funcionario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Funcionario.class.getName());
		}
		return obj;
	}

	public List<Funcionario> findByNome(String nome) {
		return repo.findByNomeFuncionario(nome);
	}

	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	public List<Funcionario> findFuncPerfilAgente(){
		
		return repo.findByPerfis(Perfil.CADASTRADOR.getCod());
	}
	
	
	
}