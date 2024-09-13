package com.fatec.sigvsback.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.sigvsback.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
