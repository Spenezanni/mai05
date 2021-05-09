package br.com.mai05.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.mai05.model.Cliente;
import br.com.mai05.response.ClienteResponse;
import request.ClienteRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

	Cliente clienteRequestModel(ClienteRequest clienteRequest);
	ClienteResponse clienteResponseModel(Cliente cliente);
	List<ClienteResponse> listaResponseModel(List<Cliente> clientes);

}
