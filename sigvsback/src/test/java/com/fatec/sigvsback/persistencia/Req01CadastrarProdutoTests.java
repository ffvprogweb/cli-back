package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvsback.model.Produto;
@SpringBootTest
class Req01CadastrarProdutoTests {

	// Testes para o campo descricao
    @Test
    @DisplayName("Deve criar Produto com descrição válida")
    void deveCriarProdutoComDescricaoValida() {
        // Given
        String descricao = "Produto Teste";
        
        // When
        Produto produto = new Produto(descricao, "Eletrônicos", "10.0", "5");

        // Then
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com descrição em branco")
    void deveLancarExcecaoParaDescricaoEmBranco() {
        // Given
        String descricao = "";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto(descricao, "Eletrônicos", "10.0", "5");
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com descrição nula")
    void deveLancarExcecaoParaDescricaoNula() {
        // Given
        String descricao = null;

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto(descricao, "Eletrônicos", "10.0", "5");
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    // Testes para o campo categoria
    @Test
    @DisplayName("Deve criar Produto com categoria válida")
    void deveCriarProdutoComCategoriaValida() {
        // Given
        String categoria = "Eletrônicos";

        // When
        Produto produto = new Produto("Produto Teste", categoria, "10.0", "5");

        // Then
        assertEquals(categoria, produto.getCategoria());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com categoria em branco")
    void deveLancarExcecaoParaCategoriaEmBranco() {
        // Given
        String categoria = "";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", categoria, "10.0", "5");
        });
        assertEquals("A categoria não deve estar em branco", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com categoria nula")
    void deveLancarExcecaoParaCategoriaNula() {
        // Given
        String categoria = null;

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", categoria, "10.0", "5");
        });
        assertEquals("A categoria não deve estar em branco", exception.getMessage());
    }

    // Testes para o campo custo
    @Test
    @DisplayName("Deve criar Produto com custo válido")
    void deveCriarProdutoComCustoValido() {
        // Given
        String custo = "10.0";

        // When
        Produto produto = new Produto("Produto Teste", "Eletrônicos", custo, "5");

        // Then
        assertEquals(10.0, produto.getCusto());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com custo zero ou negativo")
    void deveLancarExcecaoParaCustoZeroOuNegativo() {
        // Given
        String custoZero = "0.0";
        String custoNegativo = "-1.0";

        // When & Then
        IllegalArgumentException exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", custoZero, "5");
        });
        assertEquals("O custo deve ser maior que zero", exceptionZero.getMessage());

        IllegalArgumentException exceptionNegativo = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", custoNegativo, "5");
        });
        assertEquals("O custo deve ser maior que zero", exceptionNegativo.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com custo inválido")
    void deveLancarExcecaoParaCustoInvalido() {
        // Given
        String custoInvalido = "abc";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", custoInvalido, "5");
        });
        assertEquals("O custo deve ser maior que zero", exception.getMessage());
    }

    // Testes para o campo quantidadeNoEstoque
    @Test
    @DisplayName("Deve criar Produto com quantidade no estoque válida")
    void deveCriarProdutoComQuantidadeNoEstoqueValida() {
        // Given
        String quantidadeNoEstoque = "5";

        // When
        Produto produto = new Produto("Produto Teste", "Eletrônicos", "10.0", quantidadeNoEstoque);

        // Then
        assertEquals(5, produto.getQuantidadeNoEstoque());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com quantidade no estoque negativa")
    void deveLancarExcecaoParaQuantidadeNoEstoqueNegativa() {
        // Given
        String quantidadeNoEstoque = "-1";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "10.0", quantidadeNoEstoque);
        });
        assertEquals("A quantidade no estoque deve ser maior que zero", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Produto com quantidade no estoque inválida")
    void deveLancarExcecaoParaQuantidadeNoEstoqueInvalida() {
        // Given
        String quantidadeNoEstoque = "abc";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Produto Teste", "Eletrônicos", "10.0", quantidadeNoEstoque);
        });
        assertEquals("A quantidade no estoque deve ser maior que zero", exception.getMessage());
    }


}
