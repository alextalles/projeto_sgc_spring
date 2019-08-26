package com.alexviana.sgc.services;

import com.alexviana.sgc.entities.Cliente;

	public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	
	Cliente editar(Cliente cliente);
	
	void excluir(Cliente cliente);
	
	/** *
	 * Busca o cpf do cliente.
	 * @param cpf
	 * @return
	 */
	Cliente buscarPorCpf(String cpf);
	
	/** *
	 * Busca o cnpj do cliente.
	 * @param cnpj
	 * @return
	 */
	Cliente buscarPorCnpf(String cnpj);
	
	/** *
	 * Busca o e-mail do cliente.
	 * @param cnpj
	 * @return
	 */
	Cliente buscarPorEmail(String email);
}
