package br.com.mai05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mai05.model.Cliente;
import br.com.mai05.response.ClienteResponse;
import br.com.mai05.service.ClienteService;

@RestController
@RequestMapping
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody Cliente cliente ){
		
	}

}
