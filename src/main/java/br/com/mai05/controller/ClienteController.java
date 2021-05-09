package br.com.mai05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mai05.dto.ClienteDto;
import br.com.mai05.model.Cliente;
import br.com.mai05.response.ClienteResponse;
import br.com.mai05.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto cadastrarCliente(@RequestBody Cliente cliente) {
		ClienteDto clienteSalvo = clienteService.cadastrarCliente(cliente);
		return clienteSalvo;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteDto> listaClienteDto(){
		List<ClienteDto> listaClienteDto = clienteService.buscarListaClienteDto();
		return listaClienteDto;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}
	

}
