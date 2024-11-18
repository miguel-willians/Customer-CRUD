package com.crud.cadastro;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroApplication {

    public static void main(String[] args) {
        // Carregar variáveis do arquivo .env
        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("PGPASSWORD", dotenv.get("PGPASSWORD"));

        // Iniciar a aplicação Spring Boot
        SpringApplication.run(CadastroApplication.class, args);
    }
}
