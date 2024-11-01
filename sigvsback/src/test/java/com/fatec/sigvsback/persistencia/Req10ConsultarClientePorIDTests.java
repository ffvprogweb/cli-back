package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteRepository;
@SpringBootTest
class Req10ConsultarClientePorIDTests {
	@Autowired
    IClienteRepository repository;
	@Test
    void ct01_consultar_cliente_pelo_id_com_sucesso() {
		//********************************************************
        // dado que o cliente esta cadastrado
		//********************************************************
	    Long clienteId = 1L;
	    //********************************************************
        // quando consulto o cliente pelo id
        //********************************************************
		Cliente cliente = repository.findById(clienteId).get();
		//********************************************************
        // entao retorna os detalhes do cliente
        //********************************************************
		assertEquals("Jose da Silva", cliente.getNome());
	
	}
	@Test
    void ct02_consultar_cliente_id_invalido() {
		//********************************************************
        // dado que o id do cliente nao esta cadastrado
		//********************************************************
	    Long clienteId = 5L;
	    //********************************************************
        // quando consulto o cliente pelo id
        //********************************************************
		Optional<Cliente> cliente = repository.findById(clienteId);
		//********************************************************
        // entao retorna cliente vazio
        //********************************************************
		assertTrue(cliente.isEmpty());
	}
}
