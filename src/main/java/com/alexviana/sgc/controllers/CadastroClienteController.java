package com.alexviana.sgc.controllers;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexviana.sgc.dtos.CadastroClienteDto;
import com.alexviana.sgc.entities.Cliente;

@RestController
@RequestMapping("/cadastrar-cliente")
public class CadastroClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(CadastroClienteController.class);
	
	@Autowired
	private Cliente cliente;
		
	public CadastroClienteController() { }
	
	
	@PostMapping 
	public ResponseEntity<Response<CadastroClienteDto>> cadastrar(@Valid @RequestBody CadastroClienteDto cadastroClienteDto, BindingResult bindingResult) 
			throws Exception {
				return null; 
		//Response<CadastroClienteDto> response = new Response<CadastroClienteDto>();
	  
	}
	 
	private void validarDadosExistentes(CadastroClienteDto cadastroClienteDto, BindingResult bindingResult) {
		
	}
}
