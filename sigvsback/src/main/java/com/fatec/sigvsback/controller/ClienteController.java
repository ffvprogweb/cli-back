package com.fatec.sigvsback.controller;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteServico;



@RestController
@CrossOrigin
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	@Autowired
	IClienteServico servico;
	Logger logger = LogManager.getLogger(this.getClass());
	@GetMapping("/all")
	public List<Cliente> getAll() {
		//logger.info(">>>>>> apicontroller consulta todos iniciado...");
		return servico.consultaTodos();
	}

	@PostMapping
	public ResponseEntity<Cliente> cadastraCliente(@RequestBody Cliente cliente) {
		Optional<Cliente> c = servico.cadastrar(cliente);
		if (c.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(c.get());
		}
	}
	
	
}