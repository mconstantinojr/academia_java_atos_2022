package br.atos.cadastro_animais_zoo.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_animais_zoo.Model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

	Animal findById(long id);
	
}
