package com.alexviana.sgc.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alexviana.sgc.daos.ClienteDAO;
import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.enums.StageCliente;
import com.alexviana.sgc.enums.TipoCliente;

@RestController
@RequestMapping("/clientes")
public class CadastroClienteController {

	@Autowired 
	private ClienteDAO clienteDAO;

	/**
	 * * Listar todos os clientes cadastrados.
	 * 
	 * @return
	 */
	@GetMapping("/listar")
	public List<Cliente> listar() {
		return (List<Cliente>) clienteDAO.listar();
	}

	/** *
	 * 
	 * @param cliente
	 * @return
	 */
	@PostMapping
	public Cliente criar(@RequestBody Cliente cliente) {
		return this.clienteDAO.salvar(cliente);
	}

	/** *
	 * 
	 * @param cliente
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return incluir(cliente);
		}
		//Seta por default.
		cliente.setStage(StageCliente.ATIVO);
		clienteDAO.salvar(cliente);

		return (ModelAndView) listar();
	}

	/** *
	 * 
	 * @param cliente
	 * @return
	 */
	@GetMapping(path = { "/incluir" })
	public ModelAndView incluir(Cliente cliente) {
		return new ModelAndView("redirect:/incluir");
	}
	
	/** *
	 * 
	 * @param id
	 * @param cliente
	 * @return
	 */
	@PostMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id, @Valid @RequestBody Cliente cliente) {

		Cliente cli = clienteDAO.getId(cliente.getId());

		cli.setNome(cliente.getNome());
		cli.setCpf(cliente.getCpf());
		cli.setCnpj(cliente.getCnpj());
		cli.setEmail(cliente.getEmail());
		cli.setCodigoPostal(cliente.getCodigoPostal());
		cli.setTipo(cliente.getTipo());
		cli.setStage(cliente.getStage());
		cli.setTelefone1(cliente.getTelefone1());
		cli.setTelefone2(cliente.getTelefone2());

		clienteDAO.salvar(cliente);

		return new ModelAndView("redirect:/listar");
	}

	/** *
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = { "/excluir/{id}" })
	public ModelAndView excluir(@PathVariable long id) {

		Cliente cliente = clienteDAO.getId(id);
		clienteDAO.excluir(cliente);

		return new ModelAndView("redirect:/listar");
	}

	// Não será necessário os métodos implementados abaixo para carregar os campos.
	/** *
	 * Método para carregar o campo Tipo Cliente.
	 * @return
	 */
	private List<TipoCliente> carregarlistaTipos() {
		return Arrays.asList(TipoCliente.values());
	}
	
	/** *
	 * Método para carregar o campo Stage Cliente.
	 * @return
	 */
	private List<StageCliente> carregarListaStage() {
		return Arrays.asList(StageCliente.values());
	}
}
