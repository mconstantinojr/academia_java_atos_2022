package com.atos.cadastro_pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atos.cadastro_pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findById(long id);
}
