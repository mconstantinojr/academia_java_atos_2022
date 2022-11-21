package br.atos.cadastro_animais_zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CadastroAnimaisZooApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroAnimaisZooApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("Senha"));
	}

}
