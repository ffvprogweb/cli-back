package com.fatec.sigvsback.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteServico;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/clientes")
public class TestController {
	@Autowired
	IClienteServico servico;
	Logger logger = LogManager.getLogger(this.getClass());

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluirClientePorId(@PathVariable("id") String id) {
		logger.info(">>>>>> apicontroller exluir por id chamado");
		Optional<Cliente> produto = servico.consultarPorId(id);
		if (produto.isEmpty()) {
			logger.info(">>>>>> apicontroller id not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
		} else {
			servico.excluir(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
}
