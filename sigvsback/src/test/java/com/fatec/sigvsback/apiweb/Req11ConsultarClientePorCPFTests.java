package com.fatec.sigvsback.apiweb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req11ConsultarClientePorCPFTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void ct01_cpf_invalido_retorna_msg_de_erro() {
		String URLBase = "/api/v1/clientes";
		// ********************************************************************************************
		// Given - dado que o cpf é invalido
		// ********************************************************************************************
		String cpf = "/77417451071";
		// ********************************************************************
		// When - quando confirmo o cadastro do cliente
		// ********************************************************************
		ResponseEntity<String> response = restTemplate.exchange(URLBase + cpf, HttpMethod.DELETE, null, String.class);
		// ********************************************************************
		// Then - entao retorna mensagem de erro
		// ********************************************************************
		assertThat(response.getStatusCode().value()).isEqualTo(404);
		assertThat(response.getBody()).isEqualTo("CPF não encontrado.");
		assertEquals("CPF não encontrado.", response.getBody());
		assertTrue(response.getBody().contains("CPF não encontrado."));
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
