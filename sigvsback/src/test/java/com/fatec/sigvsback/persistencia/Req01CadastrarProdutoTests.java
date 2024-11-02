package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
 // Testes para o campo descricao
    @Test
    void testDescricaoValida() {
        Produto produto = new Produto("Produto Teste", "Eletrônicos", "10.0", "5");
        assertEquals("Produto Teste", produto.getDescricao());
    }

    @Test
    void testDescricaoEmBranco() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", "Eletrônicos", "10.0", "5");
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    @Test
    void testDescricaoNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto(null, "Eletrônicos", "10.0", "5");
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    // Testes para o campo categoria
    @Test
    void testCategoriaValida() {
        Produto produto = new Produto("Produto Teste", "Eletrônicos", "10.0", "5");
        assertEquals("Eletrônicos", produto.getCategoria());
    }

    @Test
    void testCategoriaEmBranco() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "", "10.0", "5");
        });
        assertEquals("A categoria não deve estar em branco", exception.getMessage());
    }

    @Test
    void testCategoriaNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", null, "10.0", "5");
        });
        assertEquals("A categoria não deve estar em branco", exception.getMessage());
    }

    // Testes para o campo custo
    @Test
    void testCustoValido() {
        Produto produto = new Produto("Produto Teste", "Eletrônicos", "10.0", "5");
        assertEquals(10.0, produto.getCusto());
    }

    @Test
    void testCustoZeroOuNegativo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "0.0", "5");
        });
        assertEquals("O custo deve ser maior que zero", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "-1.0", "5");
        });
        assertEquals("O custo deve ser maior que zero", exception.getMessage());
    }

    @Test
    void testCustoInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "abc", "5");
        });
        assertEquals("O custo deve ser maior que zero", exception.getMessage());
    }

    // Testes para o campo quantidadeNoEstoque
    @Test
    void testQuantidadeNoEstoqueValida() {
        Produto produto = new Produto("Produto Teste", "Eletrônicos", "10.0", "5");
        assertEquals(5, produto.getQuantidadeNoEstoque());
    }

    @Test
    void testQuantidadeNoEstoqueNegativa() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "10.0", "-1");
        });
        assertEquals("A quantidade no estoque deve ser maior que zero", exception.getMessage());
    }

    @Test
    void testQuantidadeNoEstoqueInvalida() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "10.0", "abc");
        });
        assertEquals("A quantidade no estoque deve ser maior que zero", exception.getMessage());
    }


}
