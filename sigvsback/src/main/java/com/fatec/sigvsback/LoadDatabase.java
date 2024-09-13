package com.fatec.sigvsback;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.sigvsback.model.Cliente;
import com.fatec.sigvsback.servico.IClienteRepository;

@Configuration
public class LoadDatabase {
	Logger logger = LogManager.getLogger(this.getClass());

	@Bean
	CommandLineRunner initDatabase(IClienteRepository repository) {
		return args -> {
			Cliente cliente1 = new Cliente("Jose da Silva", "Av Paulista");
			Cliente cliente2 = new Cliente("Maria Souza", "Av Consolacao");
			Cliente cliente3 = new Cliente("David Gordon", "Av do Estado");
			repository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
			logger.info(">>>>> loaddatabase -> cadastro de 3 produtos realizado.");
		};
	}
}
