package br.com.mai05.service;

import java.util.List;

import br.com.mai05.response.ClienteResponse;
import request.ClienteRequest;

public interface ClienteService {

	ClienteResponse cadastrarCliente(ClienteRequest clienteRequest);

	List<ClienteResponse> buscarListaClienteResponse();

}
