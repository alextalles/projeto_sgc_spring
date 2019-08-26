package com.alexviana.sgc.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.repositories.ClienteRepository;

@Service
public class ClienteDAO {

	@Autowired
	private ClienteRepository clienteRepository;
	

	public Cliente getId(Long id) {
		return this.clienteRepository.getOne(id);
	}

	public List<Cliente> listar() {
		return this.clienteRepository.findAll();
	}

	public void editar(Cliente cliente) {
		this.clienteRepository.saveAndFlush(cliente);
	}

	public void excluir(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
