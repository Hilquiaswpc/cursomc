package com.hilquias.resources;


import com.hilquias.domain.Cliente;
import com.hilquias.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/clientes")

public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity  <Cliente> find(@PathVariable Integer id ) {
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj); 
		 
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity  <?> findAll() {
		Cliente obj = service.ClienteAll();
		return ResponseEntity.ok().body(obj);

	}
}