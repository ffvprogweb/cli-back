package com.fatec.sigvsback;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fatec.sigvsback.model.Cliente;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req01CadastrarCliente {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	// @DisplayName("CT01 Cadastrar cliente com sucesso")
	void ct01_cadastrar_cliente_com_sucesso() {
		String URLBase = "/api/v1/clientes";
		//********************************************************************
		// Given - dado que as informacoes de cliente sao validas
		//********************************************************************
		Cliente cliente = new Cliente(1, "Jose da Silva", "Rua Augusta, 123");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Cliente> request = new HttpEntity<>(cliente, headers);
		//********************************************************************
		// When - quando confirmo o cadastro do cliente
		//********************************************************************
		ResponseEntity<Cliente> response = restTemplate.exchange(URLBase, HttpMethod.POST, request, Cliente.class);
		//********************************************************************
		// Then - entao retorna os detalhes do cliente cadastrado
		//********************************************************************
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Cliente clienteCadastrado = response.getBody();
		assertEquals("Jose da Silva", clienteCadastrado.getNome());
		assertEquals("Rua Augusta, 123", clienteCadastrado.getEndereco());
		assertEquals(1, clienteCadastrado.getId()); // Verifica se o ID foi setado corretamente
	}
}
