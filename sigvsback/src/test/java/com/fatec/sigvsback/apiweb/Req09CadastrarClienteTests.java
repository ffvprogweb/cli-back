package com.fatec.sigvsback.apiweb;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
class Req09CadastrarClienteTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void ct01_cadastrar_cliente_com_sucesso() {
		String URLBase = "/api/v1/clientes";
		//********************************************************************************************
		// Given - dado que as informacoes de cliente sao validas E que existem 3 clientes cadastrados
		//********************************************************************************************
		Cliente cliente = new Cliente("77417451071", "Jose da Silva", "01304-000");
		cliente.setDataCadastro();
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
		
		assertEquals(4, clienteCadastrado.getId()); // Verifica se o ID foi setado corretamente
	}
	
	@Test
	void ct02_cadastrar_cliente_com_descricao_invalida() {
		
	}
	
	
	
	
	
	
	
	

}