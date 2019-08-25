package com.alexviana.sgc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexviana.sgc.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	// Recursos do Java 8
	public Cliente findByCpf(String cpf);
	
	public Cliente findByCnpj(String cnpj);
	
	public Cliente findByEmail(String email);
}
