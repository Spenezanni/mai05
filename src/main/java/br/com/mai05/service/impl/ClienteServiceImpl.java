package br.com.mai05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mai05.mapper.ClienteMapper;
import br.com.mai05.model.Cliente;
import br.com.mai05.repository.ClienteRepository;
import br.com.mai05.response.ClienteResponse;
import br.com.mai05.service.ClienteService;
import request.ClienteRequest;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private ClienteMapper clienteMapper;

	@Override
	public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
		Cliente cliente = clienteRepository.save(clienteMapper.clienteRequestModel(clienteRequest));
		return clienteMapper.clienteResponseModel(cliente);
	}

	@Override
	public List<ClienteResponse> buscarListaClienteResponse() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		return clienteMapper.listaResponseModel(listaCliente);
	}

}
