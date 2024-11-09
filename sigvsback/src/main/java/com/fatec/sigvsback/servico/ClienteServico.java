package com.fatec.sigvsback.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.model.Endereco;

import jakarta.transaction.Transactional;

@Service
public class ClienteServico implements IClienteServico {
	Logger logger = LogManager.getLogger(ClienteServico.class);
	@Autowired
	IClienteRepository repository;
	@Autowired
	private EnderecoService enderecoService;

	@Override
	public List<Cliente> consultaTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Optional<Cliente> cadastrar(Cliente cliente) {
		cliente.setDataCadastro();
		Optional<String> endereco = enderecoService.obtemLogradouroPorCep(cliente.getCep());
		
		if (endereco.isEmpty()) {
			logger.warn(">>>>>> Endereço não encontrado para o CEP: " + cliente.getCep());
			return Optional.empty();
		}
		try {
			cliente.setEndereco(endereco.get());
			logger.info(">>>>>> clienteservico - cliente cadastrado ");
			return Optional.ofNullable(repository.save(cliente));
		} catch (Exception e) {
			logger.info(">>>>>> clienteservico - erro metodo cadastrar comando save ");
			return Optional.empty();
		}
	}

	@Override
	public Optional<Cliente> consultarPorCpf(String cpf) {
		try {
			return Optional.ofNullable(repository.getByCpf(cpf));
		} catch (IllegalArgumentException e) {
			logger.info(">>>>>> clienteservico - erro metodo consulta por cpf ");
			return Optional.empty();
		}
	}

	@Override
	public Optional<Cliente> atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cliente> excluir(String cpf) {
		Optional<Cliente> c = Optional.ofNullable(repository.getByCpf(cpf));
		if (c.isEmpty()) {
			return Optional.empty();
		} else {
			repository.deleteByCpf(cpf);
			return c;
		}

	}

	@Override
	public Double estoqueImobilizado() {
		// TODO Auto-generated method stub
		return null;
	}

}