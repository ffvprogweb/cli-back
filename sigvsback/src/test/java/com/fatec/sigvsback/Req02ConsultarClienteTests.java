package com.fatec.sigvsback;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fatec.sigvsback.model.Cliente;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req02ConsultarClienteTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void ct01_cadastrar_cliente_com_sucesso() {
		String URLBase = "/api/v1/clientes/all";

		// Realiza a requisição GET para a API
		ResponseEntity<Cliente[]> response = restTemplate.getForEntity(URLBase, Cliente[].class);

		// Verifica o codigo HTTP da resposta
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Verifica o corpo da resposta
		Cliente[] clientes = response.getBody();
		assertThat(clientes).hasSize(3);
		assertThat(clientes[0].getNome()).isEqualTo("Jose da Silva");
		assertThat(clientes[1].getNome()).isEqualTo("Maria Souza");
	}

}
