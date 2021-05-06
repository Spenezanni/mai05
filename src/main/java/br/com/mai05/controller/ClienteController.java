package br.com.mai05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mai05.response.ClienteResponse;
import br.com.mai05.service.ClienteService;
import request.ClienteRequest;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
		ClienteResponse clienteResponse = clienteService.cadastrarCliente(clienteRequest);
		return clienteResponse;
	}

}
