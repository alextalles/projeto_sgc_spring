package com.alexviana.sgc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class CadastroClienteController {
	
	//private ClienteService clienteService;
	
	private ClienteRepository clienteRepository;
	
	/** *
	 *  Uma prática de injeção mais moderna do que anotar como "Autowired". 
	 * @param clienteRepository
	 */
	CadastroClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	/** *
	 *  Listar todos os clientes cadastrados.
	 * @return
	 */
	@GetMapping
	public List<Cliente> findAll(){
	   return (List<Cliente>) clienteRepository.findAll();
	}
	
	/*
	 * @GetMapping public Page<Cliente> pesquisar(
	 * 
	 * @RequestParam(defaultValue = "0") int pagina,
	 * 
	 * @RequestParam(defaultValue = "10") int porPagina,
	 * 
	 * @RequestParam(defaultValue = "nome") String ordenacao,
	 * 
	 * @RequestParam(defaultValue = "ASC") Sort.Direction direcao ) { return
	 * clienteRepository.findAll(PageRequest.of(pagina, porPagina, new Sort(direcao,
	 * ordenacao))); }
	 */
	
	/** *
	 * Cria o cliente na base de dados, retorna o cliente com "id" populado e é retornado no corpo da resposta em formato "Json".
	 * @param cliente
	 * @return
	 */
	@PostMapping
	public Cliente incluir(@Valid @RequestBody Cliente cliente){
	   return this.clienteRepository.save(cliente);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") long id,  @Valid @RequestBody Cliente cliente) {
	   
		return clienteRepository.findById(id)
	           .map(record -> {
	               record.setNome(cliente.getNome());
	               record.setCpf(cliente.getCpf());
	               record.setCnpj(cliente.getCnpj());
	               record.setEmail(cliente.getEmail());
	               record.setCodigoPostal(cliente.getCodigoPostal());
	               record.setTipo(cliente.getTipo());
	               record.setStage(cliente.getStage());
	               record.setTelefone1(cliente.getTelefone1());
	               record.setTelefone2(cliente.getTelefone2());
	               
	               Cliente clienteAtualizado = clienteRepository.save(record);
	               return ResponseEntity.ok().body(clienteAtualizado);
	               
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> excluir(@Valid @PathVariable long id) {
		
	   return clienteRepository.findById(id)
	           .map(record -> {
	        	   clienteRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	               
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	/*
	 * private void validarDadosExistentes(CadastroClienteDto cadastroClienteDto) {
	 * Cliente cpf = this.clienteService.buscarPorCpf(cadastroClienteDto.getCpf());
	 * }
	 */
}
