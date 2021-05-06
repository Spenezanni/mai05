package br.com.mai05.service;

import br.com.mai05.response.ClienteResponse;
import request.ClienteRequest;

public interface ClienteService {

	ClienteResponse cadastrarCliente(ClienteRequest clienteRequest);

}
