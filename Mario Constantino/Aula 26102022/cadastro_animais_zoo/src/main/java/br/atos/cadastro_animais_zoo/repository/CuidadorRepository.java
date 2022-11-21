package br.atos.cadastro_animais_zoo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_animais_zoo.Model.Cuidador;

public interface CuidadorRepository extends CrudRepository<Cuidador, Long> {
	@Query(value = "SELECT CASE WHEN MAX(C.idCuidador) IS NULL THEN 0 ELSE MAX(C.idCuidador) END  FROM Cuidador C")
	Integer maxIdConsumidor();
	
	Cuidador findById(long id);
}
