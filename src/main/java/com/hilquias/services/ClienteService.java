package com.hilquias.services;

import com.hilquias.domain.Cliente ;
import com.hilquias.repositories.ClienteRepository;
import com.hilquias.repositories.ClienteRepository;
import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Cliente  ClienteAll(){
		List<Cliente > obj = repo.findAll();
		return (Cliente) obj;
	}

}
