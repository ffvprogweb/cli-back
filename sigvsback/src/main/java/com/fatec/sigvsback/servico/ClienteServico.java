package com.fatec.sigvsback.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.model.IClienteRepository;
@Service
public class ClienteServico implements IClienteServico {
	@Autowired
	IClienteRepository repository;

	@Override
	public List<Cliente> consultaTodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> cadastrar(Cliente cliente) {
		return Optional.ofNullable(repository.save(cliente));
	}

	@Override
	public Optional<Cliente> consultarPorId(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cliente> atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void excluir(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double estoqueImobilizado() {
		// TODO Auto-generated method stub
		return null;
	}

}
