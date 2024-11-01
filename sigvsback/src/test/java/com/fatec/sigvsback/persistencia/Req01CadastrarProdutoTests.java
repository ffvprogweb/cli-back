package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvsback.model.Produto;
import com.fatec.sigvsback.servico.IProdutoRepository;
@SpringBootTest
class Req01CadastrarProdutoTests {

	@Autowired
    IProdutoRepository repository;

    @Test
    void ct01CadastrarProdutoComSucesso() {
    	//dado que o usuario entrou com informacoes validas
        Produto produto1 = new Produto("eletrobomba 110v", "máquina de lavar", "22.30", "10");
        //quando confirmo a operacao de cadastro
        repository.save(produto1);
        //entao o produto fica disponivel para consulta
        assertEquals(1, repository.count());
    }
    @Test
    void ct02_cadastrar_produto_com_descricao_invalida() {
    	//dado que o usuario entrou com informacoes invalidas
    	//quando confirmo a operacao de cadastro
    	try {
        Produto produto1 = new Produto("", "máquina de lavar", "22.30", "10");
        fail("deveria falhar descrição invalida");
        //entao retorna descricao invalida
    	}catch (IllegalArgumentException e) {
    		assertEquals("A descrição não deve estar em branco", e.getMessage());
    	}
        
        
    }


}
