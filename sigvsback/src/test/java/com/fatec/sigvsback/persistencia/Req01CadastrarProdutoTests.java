package com.fatec.sigvsback.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
        Produto produto1 = new Produto("eletrobomba 110v", "máquina de lavar", "22.30", "10");
        repository.save(produto1);
        assertEquals(1, repository.count());
    }


}
