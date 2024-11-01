package com.fatec.sigvsback;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteServico;

@Configuration
public class LoadDatabase {
	Logger logger = LogManager.getLogger(this.getClass());
	@Bean
	CommandLineRunner initDatabase(IClienteServico servico) {
		return args -> {
			Cliente cliente1 = new Cliente("83965248073","Jose da Silva", "01304-000");
			Cliente cliente2 = new Cliente("57241774043","Maria Souza", "01039-000");
			Cliente cliente3 = new Cliente("02800549041", "David Gordon", "03105-000");
			servico.cadastrar(cliente1);
			servico.cadastrar(cliente2);
			servico.cadastrar(cliente3);
			logger.info(">>>>> loaddatabase -> 3 clientes cadastrados.");
		};
	}
}
