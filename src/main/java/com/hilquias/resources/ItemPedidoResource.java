package com.hilquias.resources;

import com.hilquias.domain.ItemPedido;
import com.hilquias.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/pedidos")

public class ItemPedidoResource {
	
	@Autowired
	private ItemPedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity  <?> find(@PathVariable Integer id ) {
		ItemPedido obj = service.buscar(id); 
		return ResponseEntity.ok().body(obj); 
		 
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity  <?> findAll() {
		ItemPedido obj = service.ItemPedidoAll();
		return ResponseEntity.ok().body(obj);

	}
}