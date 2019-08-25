package com.alexviana.sgc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexviana.sgc.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	public String buscarPorCpf(String cpf);
	
	public String buscarPorCnpj(String cnpj);
	
	public String buscarPorEmail(String email);
	
}
