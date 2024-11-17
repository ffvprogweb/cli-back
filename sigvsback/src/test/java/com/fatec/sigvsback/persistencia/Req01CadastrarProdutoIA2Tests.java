package com.fatec.sigvsback.persistencia;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.fatec.sigvsback.model.Produto;

@SpringBootTest
class Req01CadastrarProdutoIA2Tests {

	@Nested
	@DisplayName("Dado uma descrição válida")
	class DescricaoValida {

		@Test
		@DisplayName("Quando a descrição é preenchida, então não deve lançar exceção")
		void descricaoValidaNaoLancaExcecao() {
			Produto produto = new Produto();
			assertDoesNotThrow(() -> produto.setDescricao("Produto A"));
		}
	}

	@Nested
	@DisplayName("Dado uma descrição inválida")
	class DescricaoInvalida {

		@Test
		@DisplayName("Quando a descrição é nula, então deve lançar IllegalArgumentException")
		void descricaoNulaLancaExcecao() {
			Produto produto = new Produto();
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
			        () -> produto.setDescricao(null));
			assertEquals("A descrição não deve estar em branco1", exception.getMessage());
		}

		@Test
		@DisplayName("Quando a descrição é vazia, então deve lançar IllegalArgumentException")
		void descricaoVaziaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setDescricao(""),
					"A descrição não deve estar em branco");
		}
	}

	@Nested
	@DisplayName("Dado uma categoria válida")
	class CategoriaValida {

		@Test
		@DisplayName("Quando a categoria é preenchida, então não deve lançar exceção")
		void categoriaValidaNaoLancaExcecao() {
			Produto produto = new Produto();
			assertDoesNotThrow(() -> produto.setCategoria("Eletrônicos"));
		}
	}

	@Nested
	@DisplayName("Dado uma categoria inválida")
	class CategoriaInvalida {

		@Test
		@DisplayName("Quando a categoria é nula, então deve lançar IllegalArgumentException")
		void categoriaNulaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setCategoria(null),
					"A categoria não deve estar em branco");
		}

		@Test
		@DisplayName("Quando a categoria é vazia, então deve lançar IllegalArgumentException")
		void categoriaVaziaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setCategoria(""),
					"A categoria não deve estar em branco");
		}
	}

	@Nested
	@DisplayName("Dado um custo válido")
	class CustoValido {

		@Test
		@DisplayName("Quando o custo é positivo, então não deve lançar exceção")
		void custoPositivoNaoLancaExcecao() {
			Produto produto = new Produto();
			assertDoesNotThrow(() -> produto.setCusto("10.5"));
		}
	}

	@Nested
	@DisplayName("Dado um custo inválido")
	class CustoInvalido {

		@Test
		@DisplayName("Quando o custo é zero, então deve lançar IllegalArgumentException")
		void custoZeroLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setCusto("0"),
					"O custo deve ser maior que zero");
		}

		@Test
		@DisplayName("Quando o custo é negativo, então deve lançar IllegalArgumentException")
		void custoNegativoLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setCusto("-1"),
					"O custo deve ser maior que zero");
		}

		@Test
		@DisplayName("Quando o custo é uma string inválida, então deve lançar IllegalArgumentException")
		void custoStringInvalidaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setCusto("abc"),
					"O custo deve ser maior que zero");
		}
	}

	@Nested
	@DisplayName("Dado uma quantidade no estoque válida")
	class QuantidadeNoEstoqueValida {

		@Test
		@DisplayName("Quando a quantidade é positiva, então não deve lançar exceção")
		void quantidadePositivaNaoLancaExcecao() {
			Produto produto = new Produto();
			assertDoesNotThrow(() -> produto.setQuantidadeNoEstoque("5"));
		}
	}

	@Nested
	@DisplayName("Dado uma quantidade no estoque inválida")
	class QuantidadeNoEstoqueInvalida {

		@Test
		@DisplayName("Quando a quantidade é negativa, então deve lançar IllegalArgumentException")
		void quantidadeNegativaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeNoEstoque("-1"),
					"A quantidade no estoque deve ser maior que zero");
		}

		@Test
		@DisplayName("Quando a quantidade é uma string inválida, então deve lançar IllegalArgumentException")
		void quantidadeStringInvalidaLancaExcecao() {
			Produto produto = new Produto();
			assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeNoEstoque("abc"),
					"A quantidade no estoque deve ser maior que zero");
		}
	}
}
