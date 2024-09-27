package com.fatec.sigvsback.servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.sigvsback.model.Produto;
@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
	
}

