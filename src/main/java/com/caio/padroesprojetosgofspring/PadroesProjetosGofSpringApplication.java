package com.caio.padroesprojetosgofspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesProjetosGofSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetosGofSpringApplication.class, args);
	}

}
