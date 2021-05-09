package br.com.mai05.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mai05.dto.ClienteDto;
import br.com.mai05.mapper.ClienteMapper;
import br.com.mai05.model.Cliente;
import br.com.mai05.repository.ClienteRepository;
import br.com.mai05.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	private ClienteMapper clienteMapper;
	
	
	@Override
	public ClienteDto cadastrarCliente(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return new ClienteDto(clienteSalvo);
	}

	@Override
	public List<ClienteDto> buscarListaClienteDto() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		return ClienteDto.converter(listaCliente) ;
	}

	@Override
	public void deleteCliente(Long id) {
		boolean validacao = validarClient(id);
		if(validacao) {
			clienteRepository.deleteById(id);			
		}else {
			System.out.println("Cliente não encontrado");
		}
		
	}

	private boolean validarClient(Long id) {
		Optional<Cliente> findById = clienteRepository.findById(id);
		if(findById.isPresent()) {
			return true;
		}
		return false;
	}

}
