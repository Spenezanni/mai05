package br.com.mai05.service;

import java.util.List;

import br.com.mai05.dto.ClienteDto;
import br.com.mai05.model.Cliente;
import br.com.mai05.response.ClienteResponse;

public interface ClienteService {

	ClienteDto cadastrarCliente(Cliente cliente);

	List<ClienteDto> buscarListaClienteDto();

	void deleteCliente(Long id);

}
