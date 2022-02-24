package com.hilquias.services;

import com.hilquias.domain.ItemPedido;
import com.hilquias.repositories.ItemPedidoRepository;
import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repo;
	 
	public ItemPedido find(Integer id) {
		Optional<ItemPedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ItemPedido.class.getName()));
	}
	public ItemPedido ItemPedidoAll(){
		List<ItemPedido> obj = repo.findAll();
		return (ItemPedido) obj;
	}

}
