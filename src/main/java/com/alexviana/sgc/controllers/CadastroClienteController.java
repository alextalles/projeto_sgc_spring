package com.alexviana.sgc.controllers;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexviana.sgc.dtos.CadastroClienteDto;
import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.services.ClienteService;

@RestController
@RequestMapping("/cadastrar-clientes")
public class CadastroClienteController {
	
	//Servirá para inputs dos logs no console.
	//private static final Logger logger = LoggerFactory.getLogger(CadastroClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping 
	private ResponseEntity<Response<CadastroClienteDto>> cadastrar(@Valid @RequestBody CadastroClienteDto cadastroClienteDto) throws Exception {
	
		Cliente cliente = converterDtoParaCliente(cadastroClienteDto);
		this.clienteService.salvar(cliente);
		return null;
	}
	
	// Converte os dados do Dto para Cliente.
	private Cliente converterDtoParaCliente(CadastroClienteDto cadastroClienteDto) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setNome(cadastroClienteDto.getNome());
		cliente.setCpf(cadastroClienteDto.getCpf());
		cliente.setCnpj(cadastroClienteDto.getCnpj());
		cliente.setEmail(cadastroClienteDto.getEmail());
		cliente.setCodigoPostal(cadastroClienteDto.getCodigoPostal());
		cliente.setTipo(cadastroClienteDto.getTipo());
		cliente.setStage(cadastroClienteDto.getStage());
		
		return cliente;
		
	}
	
	private void validarDadosExistentes(CadastroClienteDto cadastroClienteDto) {
		Cliente cpf = this.clienteService.buscarPorCpf(cadastroClienteDto.getCpf());
	}	
}
