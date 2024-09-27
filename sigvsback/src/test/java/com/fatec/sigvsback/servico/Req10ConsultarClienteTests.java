package com.fatec.sigvsback.servico;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteRepository;
import com.fatec.sigvsback.servico.IClienteServico;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req10ConsultarClienteTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	IClienteRepository repository;
	@Autowired
	IClienteServico servico;
	@Test
	void ct01_consultar_todos_clientes_com_sucesso() {
		//dado que existem clientes cadastrados no banco
		String URLBase = "/api/v1/clientes/all";

		// quand consulto os detalhes do cliente
		ResponseEntity<Cliente[]> response = restTemplate.getForEntity(URLBase, Cliente[].class);

		// entao retorna os detalhes dos clientes cadastrados
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		Cliente[] clientes = response.getBody();
		assertThat(clientes).hasSize(3);
		assertThat(clientes[0].getNome()).isEqualTo("Jose da Silva");
		assertThat(clientes[1].getNome()).isEqualTo("Maria Souza");
	}
	
	
}
