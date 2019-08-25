package com.alexviana.sgc.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.alexviana.sgc.enums.StageEnum;
import com.alexviana.sgc.enums.TipoEnum;

public class CadastroClienteDto {

	private Long id;
	private String nome;
	private String codigoPostal;
	private String email;
	private TipoEnum tipo;
	private StageEnum stage;
	private String cpf;
	private String cnpj;
	private String telefone1;
	private String telefone2;
	
	public CadastroClienteDto() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome é obrigatório!")
	@Length(min = 4, max = 100, message = "Nome deve conter entre 4 a 100 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@NotEmpty(message = "E-mail é obrigatório!")
	@Length(min = 8, max = 40, message = "E-mail deve conter entre 8 a 40 caracteres.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public StageEnum getStage() {
		return stage;
	}

	public void setStage(StageEnum stage) {
		this.stage = stage;
	}

	@NotEmpty(message = "CPF é obrigatório!")
	@CPF(message = "CPF inválido!")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotEmpty(message = "CNPJ é obrigatório!")
	@CNPJ(message = "CNPJ inválido!")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
}
