package com.gionni.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gionni.crm.model.Cliente;
import com.gionni.crm.repository.ClienteRepository;

@RestController // Declarando classe para ser REST
@RequestMapping("/clientes")  //mapea os endpoints - ex: /clientes
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteReposity;
	
	@GetMapping
	public List<Cliente> listar () {
		return clienteReposity.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //Retorna código 201 do protocolo HTTP - CREATED
	public Cliente adicionar (@RequestBody Cliente cliente) {
		return clienteReposity.save(cliente);
		
	}
	
	

}
