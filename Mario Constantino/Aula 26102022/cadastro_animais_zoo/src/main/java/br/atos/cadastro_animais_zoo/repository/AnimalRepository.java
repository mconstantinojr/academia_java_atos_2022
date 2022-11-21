package br.atos.cadastro_animais_zoo.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_animais_zoo.Model.Animal;
import br.atos.cadastro_animais_zoo.Model.Jaula;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

	Iterable<Animal> findByJaula(Jaula jaula);
	Animal findById(long id);
	
}
