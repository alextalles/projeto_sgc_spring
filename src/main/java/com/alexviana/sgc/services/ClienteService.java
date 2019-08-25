package com.alexviana.sgc.services;

import com.alexviana.sgc.entities.Cliente;

public interface ClienteService {
	
	/** *
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente salvar(Cliente cliente);
	
	/** *
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente editar(Cliente cliente);
	
	/** *
	 * 
	 * @param cliente
	 * @return
	 */
	public void excluir(Cliente cliente);
	
	/** *
	 * Busca o cpf do cliente.
	 * @param cpf
	 * @return
	 */
	public Cliente buscarPorCpf(String cpf);
	
	/** *
	 * Busca o cnpj do cliente.
	 * @param cnpj
	 * @return
	 */
	public Cliente buscarPorCnpf(String cnpj);
	
	/** *
	 * Busca o e-mail do cliente.
	 * @param cnpj
	 * @return
	 */
	public Cliente buscarPorEmail(String email);
}
