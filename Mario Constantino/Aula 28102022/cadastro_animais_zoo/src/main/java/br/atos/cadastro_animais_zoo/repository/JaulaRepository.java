package br.atos.cadastro_animais_zoo.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_animais_zoo.Model.Jaula;

public interface JaulaRepository extends CrudRepository<Jaula, Long> {
	
	Jaula findById(long id);
}
