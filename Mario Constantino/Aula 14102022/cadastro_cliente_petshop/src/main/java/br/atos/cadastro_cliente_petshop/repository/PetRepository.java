package br.atos.cadastro_cliente_petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_cliente_petshop.model.Cliente;
import br.atos.cadastro_cliente_petshop.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
	
	Iterable<Pet> findByCliente(Cliente cliente);
	Pet findById(long id);
	
}
