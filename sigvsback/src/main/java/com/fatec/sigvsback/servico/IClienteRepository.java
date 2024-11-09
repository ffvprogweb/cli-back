package com.fatec.sigvsback.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.sigvsback.model.Cliente;

import jakarta.transaction.Transactional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	@Transactional
    void deleteByCpf(String cpf);
	Cliente getByCpf(String cpf);
}
