package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.fatec.sigvsback.model.Produto;

class Req01CadastrarProdutoDDTests {

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void testProdutoCreation(String descricao, String categoria, String custo, String quantidadeNoEstoque,
			String resultadoEsperado) {
		try {
			// Dado que as condicoes de teste foram estabelecidas no arquivo data.csv
			Produto produto = new Produto(descricao, categoria, custo, quantidadeNoEstoque);
			assertEquals("sucesso", resultadoEsperado);
		} catch (IllegalArgumentException e) {
			// Se uma exceção for lançada, o resultado esperado é avaliado de acordo com o arquivo data.csv
			assertEquals(resultadoEsperado, e.getMessage());
		}
	}
}
