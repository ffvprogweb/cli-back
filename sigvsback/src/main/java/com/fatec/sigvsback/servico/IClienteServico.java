package com.fatec.sigvsback.servico;

import java.util.List;
import java.util.Optional;

import com.fatec.sigvsback.model.Cliente;

public interface IClienteServico {
	public List<Cliente> consultaTodos();
	public Optional<Cliente> cadastrar(Cliente cliente);
	public Optional<Cliente> consultarPorCpf(String cpf);
	public Optional<Cliente> atualizar(Long id, Cliente cliente);
	public Optional<Cliente> excluir(String cpf);
	public Double estoqueImobilizado();
}
