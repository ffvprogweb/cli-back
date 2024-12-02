package com.fatec.sigvsback.servico;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvsback.model.Cliente;
@SpringBootTest
class Req11ConsultarClientePorCPFTests {
	@Autowired
	ClienteServico servico;

	@Test
	void ct01_consultar_cleinte_com_sucesso() {
		Optional<Cliente> cliente = servico.consultarPorCpf("83965248073");
		assertTrue(cliente.isPresent());
		
	}
	@Test
	void ct02_consultar_cleinte_com_sucesso() {
		Optional<Cliente> cliente = servico.consultarPorCpf("%%%83965248073");
		assertFalse(cliente.isPresent());
		
	}
}
