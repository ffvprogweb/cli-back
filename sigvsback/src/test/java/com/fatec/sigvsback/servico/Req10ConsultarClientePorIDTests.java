package com.fatec.sigvsback.servico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
import com.fatec.sigvsback.servico.IClienteRepository;
import com.fatec.sigvsback.servico.IClienteServico;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req10ConsultarClientePorIDTests {

	
	
	@Autowired
	IClienteServico servico;
	@Test
	void ct01_consultar_cliente_por_id_com_sucesso() {
		//********************************************************
        // dado que o cliente esta cadastrado
		//********************************************************
	    Long clienteId = 1L;
	    //********************************************************
        // quando consulto o cliente pelo id
        //********************************************************
		Cliente cliente = servico.consultarPorId(clienteId).get();
		//********************************************************
        // entao retorna os detalhes do cliente
        //********************************************************
		assertEquals("Jose da Silva", cliente.getNome());
		
	}
	
	
	
}
