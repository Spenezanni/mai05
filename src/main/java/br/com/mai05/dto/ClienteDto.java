package br.com.mai05.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mai05.model.Cliente;
import br.com.mai05.model.Endereco;

public class ClienteDto {

	private long id;
	private String nome;
	private String sobrenome;
	private String cpf;

	private Endereco endereco;

	public ClienteDto(Cliente clienteSalvo) {
		this.id = clienteSalvo.getId();
		this.nome = clienteSalvo.getNome();
		this.sobrenome = clienteSalvo.getSobrenome();
		this.cpf = clienteSalvo.getCpf();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientList){
		return clientList.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
