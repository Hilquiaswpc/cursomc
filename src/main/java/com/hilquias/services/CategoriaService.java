package com.hilquias.services;

import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilquias.domain.Categoria;
import com.hilquias.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	 
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	public Categoria CategoriaAll(){
		List<Categoria> obj = repo.findAll();
		return (Categoria) obj;
	}
	public Categoria Insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);


	}

}
