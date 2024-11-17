package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvsback.model.Cliente;

@SpringBootTest
class Req09CadastrarClienteTests {

	@Test
	@DisplayName("Quando o CPF é válido, então deve criar o cliente com sucesso")
	void ct01_deveCriarClienteComCpfValido() {
		// Given
		String cpf = "12345678909";
		String nome = "João Silva";
		String cep = "12345678";

		// When
		Cliente cliente = new Cliente(cpf, nome, cep);

		// Then
		assertEquals(cpf, cliente.getCpf());
		assertEquals(nome, cliente.getNome());
		assertEquals(cep, cliente.getCep());
	}

	@Test
	@DisplayName("Quando o CPF é inválido, então deve lançar IllegalArgumentException")
	void ct02_deveLancarExcecaoParaCpfInvalido() {
		// Given
		String cpfInvalido = "12345678900";
		String nome = "João Silva";
		String cep = "12345678";

		// When & Then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cliente(cpfInvalido, nome, cep);
		});
		assertEquals("CPF invalido", exception.getMessage());
	}

	@Test
	@DisplayName("Quando o nome é nulo ou vazio, então deve lançar IllegalArgumentException")
	void ct03_deveLancarExcecaoParaNomeNuloOuVazio() {
		// Given
		String cpf = "12345678909";
		String nomeInvalido = "";
		String cep = "12345678";

		// When & Then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Cliente(cpf, nomeInvalido, cep);
		});
		assertEquals("O nome não deve estar em branco", exception.getMessage());
	}

	@Test
	@DisplayName("Quando o CEP é válido, então deve criar o cliente com o CEP fornecido")
	void ct04_deveCriarClienteComCepValido() {
		// Given
		String cpf = "12345678909";
		String nome = "João Silva";
		String cep = "87654321";

		// When
		Cliente cliente = new Cliente(cpf, nome, cep);

		// Then
		assertEquals(cep, cliente.getCep());
	}

	
}
