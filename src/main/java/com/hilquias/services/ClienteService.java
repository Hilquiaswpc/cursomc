package com.hilquias.services;

import com.hilquias.domain.Cliente;
import com.hilquias.domain.Cliente ;
import com.hilquias.dto.ClienteDTO;
import com.hilquias.repositories.ClienteRepository;
import com.hilquias.repositories.ClienteRepository;
import com.hilquias.services.exceptions.DataIntegrityException;
import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	 
	public Cliente  find(Integer id) {
		Optional<Cliente > obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente .class.getName()));
	}
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria que possue produtos  ");
		}
	}
	public List<Cliente> findAll(){
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDTO){
		//return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
		//TODO
		throw new UnsupportedOperationException();
	}

}
