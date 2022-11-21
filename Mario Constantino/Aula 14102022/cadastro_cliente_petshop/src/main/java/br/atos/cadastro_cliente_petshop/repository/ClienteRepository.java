package br.atos.cadastro_cliente_petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_cliente_petshop.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente findById(long id);
}
