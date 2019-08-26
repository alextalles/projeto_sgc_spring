package com.alexviana.sgc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexviana.sgc.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	
	Cliente findClienteByCpf(String cpf);
	
	/** *
	 * Buscar o cliente por cnpj.
	 * @param cpf
	 * @return
	 */
	Cliente findClienteByCnpj(String cnpj);
	
	/** *
	 * Buscar o cliente por e-mail.
	 * @param cpf
	 * @return
	 */
	Cliente findClienteByEmail(String email);
}
