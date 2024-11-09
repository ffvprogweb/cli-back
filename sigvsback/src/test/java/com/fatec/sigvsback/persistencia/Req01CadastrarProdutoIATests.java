package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.fatec.sigvsback.model.Produto;

class Req01CadastrarProdutoIATests {

	@Nested
    @DisplayName("Testes para a descrição")
    class DescricaoTests {
        @Test
        @DisplayName("Deve lançar exceção quando a descrição for nula")
        void deveLancarExcecaoQuandoDescricaoForNula() {
            assertThrows(IllegalArgumentException.class, () -> new Produto(null, "categoria", "10.0", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando a descrição for vazia")
        void deveLancarExcecaoQuandoDescricaoForVazia() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("", "categoria", "10.0", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando a descrição for em branco")
        void deveLancarExcecaoQuandoDescricaoForEmBranco() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("   ", "categoria", "10.0", "10"));
        }

        @Test
        @DisplayName("Deve aceitar uma descrição válida")
        void deveAceitarUmaDescricaoValida() {
            Produto produto = new Produto("Produto Teste", "categoria", "10.0", "10");
            assertEquals("Produto Teste", produto.getDescricao());
        }
    }

    @Nested
    @DisplayName("Testes para a categoria")
    class CategoriaTests {
        @Test
        @DisplayName("Deve lançar exceção quando a categoria for nula")
        void deveLancarExcecaoQuandoCategoriaForNula() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", null, "10.0", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando a categoria for vazia")
        void deveLancarExcecaoQuandoCategoriaForVazia() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "", "10.0", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando a categoria for em branco")
        void deveLancarExcecaoQuandoCategoriaForEmBranco() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "   ", "10.0", "10"));
        }

        @Test
        @DisplayName("Deve aceitar uma categoria válida")
        void deveAceitarUmaCategoriaValida() {
            Produto produto = new Produto("descricao", "categoria", "10.0", "10");
            assertEquals("categoria", produto.getCategoria());
        }
    }

    @Nested
    @DisplayName("Testes para o custo")
    class CustoTests {
        @Test
        @DisplayName("Deve lançar exceção quando o custo for zero")
        void deveLancarExcecaoQuandoCustoForZero() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "categoria", "0", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando o custo for negativo")
        void deveLancarExcecaoQuandoCustoForNegativo() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "categoria", "-10", "10"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando o custo for inválido")
        void deveLancarExcecaoQuandoCustoForInvalido() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "categoria", "abc", "10"));
        }

        @Test
        @DisplayName("Deve aceitar um custo válido")
        void deveAceitarUmCustoValido() {
            Produto produto = new Produto("descricao", "categoria", "10.50", "10");
            assertEquals(10.50, produto.getCusto());
        }
    }

    @Nested
    @DisplayName("Testes para a quantidade no estoque")
    class QuantidadeNoEstoqueTests {
        @Test
        @DisplayName("Deve lançar exceção quando a quantidade for negativa")
        void deveLancarExcecaoQuandoQuantidadeForNegativa() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "categoria", "10.0", "-1"));
        }

        @Test
        @DisplayName("Deve lançar exceção quando a quantidade for inválida")
        void deveLancarExcecaoQuandoQuantidadeForInvalida() {
            assertThrows(IllegalArgumentException.class, () -> new Produto("descricao", "categoria", "10", "abc"));
        }


        @Test
        @DisplayName("Deve aceitar uma quantidade válida")
        void deveAceitarUmaQuantidadeValida() {
            Produto produto = new Produto("descricao", "categoria", "10", "10");
            assertEquals(10, produto.getQuantidadeNoEstoque());
        }

         @Test
        @DisplayName("Deve aceitar quantidade zero")
        void deveAceitarQuantidadeZero() {
            Produto produto = new Produto("descricao", "categoria", "10", "0");
            assertEquals(0, produto.getQuantidadeNoEstoque());
        }
    }

}
