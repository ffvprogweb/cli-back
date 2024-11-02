package com.fatec.sigvsback.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fatec.sigvsback.model.Cliente;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Req10ConsultarClientePorIDTests {
	
	@Autowired
	IClienteServico servico;
	@Test
	void ct01_consultar_cliente_por_id_com_sucesso() {
		//********************************************************
        // dado que o cliente esta cadastrado
		//********************************************************
	    String clienteId = "1";
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
