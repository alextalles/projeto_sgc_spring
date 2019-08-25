package com.alexviana.sgc.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.repositories.ClienteRepository;
import com.alexviana.sgc.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;


	@Override
	public Cliente salvar(Cliente cliente) {
		logger.info("Salvando dados do cliente: {}", cliente);
		return this.clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente editar(Cliente cliente) {
		logger.info("Editando dados do cliente: {}", cliente);
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void excluir(Cliente cliente) {
		logger.info("Excluindo dados do cliente: {}", cliente);
		this.clienteRepository.delete(cliente);
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		logger.info("Buscando pelo cpf do cliente: {}", cpf);
		return this.clienteRepository.findByCpf(cpf);
	}
	
	@Override
	public Cliente buscarPorCnpf(String cnpj) {
		logger.info("Buscando pelo cnpf do cliente: {}", cnpj);
		return this.clienteRepository.findByCnpj(cnpj);
	}
	
	@Override
	public Cliente buscarPorEmail(String email) {
		logger.info("Buscando pelo e-mail do cliente: {}", email);
		return this.clienteRepository.findByEmail(email);
	}
}
