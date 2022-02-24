package com.hilquias.services;

import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilquias.domain.Pedido;
import com.hilquias.repositories.PedidoRepository;

import java.util.List;
import java.util.Optional;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	 
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	public Pedido PedidoAll(){
		List<Pedido> obj = repo.findAll();
		return (Pedido) obj;
	}

}
